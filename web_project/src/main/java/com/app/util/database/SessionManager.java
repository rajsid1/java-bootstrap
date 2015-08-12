package com.app.util.database;

import com.app.persistence.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Hashtable;

/**
 * Created by rajdeep siddhapura.
 */
public class SessionManager {

    private Hashtable<Thread, Session> threadSession;
    private static SessionManager sSessionManager = new SessionManager();

    public SessionManager() {
        threadSession = new Hashtable<>(10);
    }

    public static void closeSession(Thread thread) {
        Session session = sSessionManager.threadSession.get(thread);
        if (session != null) {
            session.close();
        }
        sSessionManager.threadSession.remove(thread);
    }

    public static Session getSession(Thread thread, boolean createNew) {
        Session session = sSessionManager.threadSession.get(thread);
        if (session != null) {
            return session;
        }

        if (createNew) {
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                sSessionManager.threadSession.put(thread, session);
                return session;
            } catch (Exception ex) {
                throw ex;
            }
        } else {
            return null;
        }
    }
}
