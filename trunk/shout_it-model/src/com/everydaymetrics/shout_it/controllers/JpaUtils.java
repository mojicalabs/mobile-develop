/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everydaymetrics.shout_it.controllers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * This class was created by Samuel Pichardo
 * @author Samuel Pichardo
 */
public class JpaUtils {

    public static String REMOVED = "Removed";
    public static String ACTIVE = "Active";
    private static String PERSISTENCE_UNIT_NAME = "shout_it-modelPU";
    private static EntityManagerFactory emf = null;

    public static void startEntityManagerFactory() {
        if (JpaUtils.emf == null) {
            JpaUtils.emf = Persistence.createEntityManagerFactory(JpaUtils.PERSISTENCE_UNIT_NAME);
        }
    }

    public static void closeEntityManagerFactory() {
        if (JpaUtils.emf != null) {
            if (emf.isOpen()) {
                System.out.println("The Factory is open.");
                emf.close();
            }
            if (emf.isOpen()) {
                System.out.println("The Factory is open.");
                emf.close();
            }
        }
    }

    public static EntityManager getEntityManager() {
        if (JpaUtils.emf == null) {
            JpaUtils.emf = Persistence.createEntityManagerFactory(JpaUtils.PERSISTENCE_UNIT_NAME);
        } else {
//            if (emf.isOpen()) {
//                emf.close();
//            }
        }
        EntityManager f = emf.createEntityManager();

        return f;
    }

    private static String extractName(Object entity) {
        if (entity != null) {

            String nameX = entity.getClass().getName();
            int index = nameX.lastIndexOf(".");

            return nameX.substring(index + 1);

        }
        return "";
    }

    private static int extractId(Object entity) {
        int objId = -1;
        try {
            Field field = null;
            field = entity.getClass().getDeclaredField("id");
            field.setAccessible(true);
            if (field.get(entity) != null) {
                objId = (Integer) field.get(entity);
            }
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objId;
    }

    private static boolean setIdToEntity(Object entity) {
        try {
            Field field = null;
            field = entity.getClass().getDeclaredField("id");
            field.setAccessible(true);
            field.set(entity, 0);
            return true;
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private static boolean setValueToFieldOfEntity(Object entity, String field, String value) {
        Field fieldX = null;
        try {
            fieldX = entity.getClass().getDeclaredField(field);
            fieldX.setAccessible(true);
            fieldX.set(entity, value);
            return true;
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private static boolean setValueToFieldOfEntity(Object entity, String field, int value) {
        Field fieldX = null;
        try {
            fieldX = entity.getClass().getDeclaredField(field);
            fieldX.setAccessible(true);
            fieldX.set(entity, value);
            return true;
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private static boolean setStatusToEntity(Object entity, String status) {
        Field field = null;
        try {
            field = entity.getClass().getDeclaredField("status");
            field.setAccessible(true);
            field.set(entity, status);
            return true;
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    private static boolean setCreationDateToEntity(Object entity) {
        Field field = null;
        try {
            field = entity.getClass().getDeclaredField("dateCreation");
            field.setAccessible(true);
            field.set(entity, new Date());
            return true;
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
//createLinkEntity(entity, entity, Object.class, true, true);
        return false;
    }

    public static int createLinkEntity(Object entity1, Object entity2, String fieldOfEntity1, String fieldOfEntity2, Class linkEntity, boolean setStatus, boolean setCreationDate) {
        Object instance = null;
        try {
            instance = linkEntity.newInstance();
            setValueToFieldOfEntity(instance, fieldOfEntity1, extractId(entity1));
            setValueToFieldOfEntity(instance, fieldOfEntity2, extractId(entity2));
        } catch (InstantiationException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

//        if (findLinkEntity(extractId(entity1), extractId(entity2), instance, fieldOfEntity1, fieldOfEntity2) != null) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            setIdToEntity(instance);
            if (setStatus) {
                setStatusToEntity(instance, ACTIVE);
            }

            if (setCreationDate) {
                setCreationDateToEntity(instance);
            }

            em.persist(instance);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
//        }
        return extractId(instance);
    }

    public static int deactivateLinkEntity(Object entity1, Object entity2, String fieldOfEntity1, String fieldOfEntity2, Class linkEntity, boolean setStatus, boolean setCreationDate) {
        Object instance = null;
        EntityManager em = null;
        Object instanceX = null;
        try {

            instance = findLinkEntity(extractId(entity1), extractId(entity2), instance, fieldOfEntity1, fieldOfEntity2);
            if (instance != null) {
                em = getEntityManager();
                em.getTransaction().begin();

                instanceX = em.getReference(instance.getClass(), extractId(instance));
                setStatusToEntity(instanceX, REMOVED);
                //participant.setStatus(JpaUtils.REMOVED);
                instanceX = em.merge(instanceX);
                em.getTransaction().commit();
            } else {
                instanceX = linkEntity.newInstance();
            }
        } catch (InstantiationException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return extractId(instanceX);
    }
//public static boolean deactivateLinkEntity(Object entity1, Object entity2, String fieldOfEntity1, String fieldOfEntity2, Class linkEntity) {
//     EntityManager em = null;
//        Object instance = null;
//        try {
//             em = getEntityManager();
//            em.getTransaction().begin();
//          instance = linkEntity.newInstance();
//            if (extractId(entity) == -1) {
//                return false;
//            }
//            participant = em.getReference(entity.getClass(), extractId(entity));
//            setStatusToEntity(participant, REMOVED);
//            //participant.setStatus(JpaUtils.REMOVED);
//            participant = em.merge(participant);
//
//            em.getTransaction().commit();
////            instance = linkEntity.newInstance();
////            setValueToFieldOfEntity(instance, fieldOfEntity1, extractId(entity1));
////            setValueToFieldOfEntity(instance, fieldOfEntity2, extractId(entity2));
//        } catch (InstantiationException ex) {
//            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            setIdToEntity(instance);
//            if (setStatus) {
//                setStatusToEntity(instance, ACTIVE);
//            }
//
//            em.merge(instance);
//            em.getTransaction().commit();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//        return extractId(instance);
//    }

    public static int createEntity(Object entity) {
        return createEntity(entity, true, true);
    }

    public static int createEntity(Object entity, boolean setStatus, boolean setCreationDate) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            setIdToEntity(entity);
            if (setStatus) {
                setStatusToEntity(entity, ACTIVE);
            }

            if (setCreationDate) {
                setCreationDateToEntity(entity);
            }

            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return extractId(entity);
    }

    //TODO DEBE SAVER SI ESTA CON STATUS REMOVED
    public static boolean existEntity(Object entity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            if (em.find(entity.getClass(), entity) != null) {
                return true;
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return true;
    }

    public static boolean editEntity(Object entity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            entity = em.merge(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Error:[editEntity] " + ex.getMessage());
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static Object findEntity(Object entity, Integer id) {
        EntityManager em = null;
        String name = extractName(entity);
        try {
            em = getEntityManager();
            if ((name != null) && (!name.isEmpty())) {

//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE l.id = :id and l.status <> :status");
                qw.setParameter("id", id);
                qw.setParameter("status", "Removed");
                List list = qw.getResultList();
                if (list != null && list.size() > 0) {
                    return list.get(0);
                }

            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }

    public static Object findHistoryEntity(String entity, int id) {
        EntityManager em = null;
        if ((entity != null) && (!entity.isEmpty())) {
            try {
                em = getEntityManager();
//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM HistoryStatus l WHERE l.entity = :entity and l.entityId = :entityId and l.status <> :status");
                qw.setParameter("entity", entity);
                qw.setParameter("entityId", id);
                qw.setParameter("status", "Removed");
                List list = qw.getResultList();
                if (list != null && list.size() > 0) {
                    return list.get(0);
                }
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        return null;
    }

//    public static List<VwSsMaEmpleadosActivos> findHistoryEnterp(String column, String value) {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            Query qw = em.createQuery("Select l.unidad AS codigo_empresa, l.emplDesc AS nombre_empresa, l.emplId from VwSsMaEmpleadosActivos l WHERE l." + column + " <> :value");
//            qw.setParameter("value", value);
//            List <VwSsMaEmpleadosActivos> listTemp = qw.getResultList();
//            List <VwSsMaEmpleadosActivos> employeeList = new ArrayList<VwSsMaEmpleadosActivos>();
//            String unidadTemp = "";
//            if (listTemp != null && listTemp.size() > 0) {
//                for (int i = 0; i < listTemp.size(); i++) {
//                    unidadTemp = listTemp.get(i).getUnidad();
//                    Query qw2 = em.createQuery("Select l.emplDesc AS nombre_empresa, l.emplId from VwSsMaEmpleadosActivos l WHERE l." + column + " <> :value AND l.unidad == " + unidadTemp.substring(1, 2) + "");
//                    List <VwSsMaEmpleadosActivos> listFinal = qw2.getResultList();
//          
//                    if (listFinal != null && listFinal.size() > 0) {
//                        for (int j = 0 ; j < listFinal.size(); j++)
//                        {
//                            employeeList.add(listFinal.get(i));
//                        }
//                    }
//                }
//
//                return employeeList;
//            }
//            
//            
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//
//
//        return null;
//
//    }

    public static Object findLinkEntity(Integer idEntity1, Integer idEntity2, Object linkEntity, String fieldOfEntity1, String fieldOfEntity2) {
        EntityManager em = null;
        String name = extractName(linkEntity);
        if ((name != null) && (!name.isEmpty())) {
            try {
                em = getEntityManager();
//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE l." + fieldOfEntity1 + "= :field1 and l." + fieldOfEntity2 + "= :field2 and l.status <> :status");
                qw.setParameter("field1", idEntity1);
                qw.setParameter("field2", idEntity2);
                qw.setParameter("status", "Removed");
                List list = qw.getResultList();
                if (list != null && list.size() > 0) {
                    return list.get(0);
                }
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        return null;
    }

    public static Object findLinkEntity(Integer idEntity1, Object linkEntity, String fieldOfEntity1) {
        EntityManager em = null;
        String name = extractName(linkEntity);
        if ((name != null) && (!name.isEmpty())) {
            try {
                em = getEntityManager();
//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE l." + fieldOfEntity1 + "= :field1 and l.status <> :status");
                qw.setParameter("field1", idEntity1);
                qw.setParameter("status", "Removed");
                List list = qw.getResultList();
                return list;
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        return new ArrayList<Object>();
    }

    public static Object findEntityForField(Object entity, String fieldOfEntity, int valueOfField, String field2OfEntity, int valueOfField2) {
        EntityManager em = null;
        String name = extractName(entity);
        if ((name != null) && (!name.isEmpty())) {
            try {
                em = getEntityManager();
//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE l." + fieldOfEntity + "= :field1 and l." + field2OfEntity + "= :field2 and l.status <> :status");
                qw.setParameter("field1", valueOfField);
                qw.setParameter("field2", valueOfField2);
                qw.setParameter("status", "Removed");
                List list = qw.getResultList();

                if (list != null && list.size() > 0) {
                    return list.get(0);
                }
                return list;
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        return new ArrayList<Object>();
    }

    public static Object findEntityForField(Object entity, String fieldOfEntity, int valueOfField, String field2OfEntity, String valueOfField2) {
        EntityManager em = null;
        String name = extractName(entity);
        if ((name != null) && (!name.isEmpty())) {
            try {
                em = getEntityManager();
//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE l." + fieldOfEntity + "= :field1 and l." + field2OfEntity + "= :field2 and l.status <> :status");
                qw.setParameter("field1", valueOfField);
                qw.setParameter("field2", valueOfField2);
                qw.setParameter("status", "Removed");
                List list = qw.getResultList();

                if (list != null && list.size() > 0) {
                    return list.get(0);
                }
                return null;
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        return null;
    }

    public static Object findEntityForField(Object entity, String fieldOfEntity, String valueOfField, String field2OfEntity, String valueOfField2) {
        EntityManager em = null;
        String name = extractName(entity);
        if ((name != null) && (!name.isEmpty())) {
            try {
                em = getEntityManager();
//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE l." + fieldOfEntity + "= :field1 and l." + field2OfEntity + "= :field2 and l.status <> :status");
                qw.setParameter("field1", valueOfField);
                qw.setParameter("field2", valueOfField2);
                qw.setParameter("status", "Removed");
                List list = qw.getResultList();

                if (list != null) {
                    return list;
                }
                return list;
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        return new ArrayList<Object>();
    }

    public static Object findEntityForFieldNoStatus(Object entity, String fieldOfEntity, String valueOfField) {
        EntityManager em = null;
        String name = extractName(entity);
        if ((name != null) && (!name.isEmpty())) {
            try {
                em = getEntityManager();
//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE l." + fieldOfEntity + "= :field1");
                qw.setParameter("field1", valueOfField);
                // qw.setParameter("status", "Removed");
                List list = qw.getResultList();

                if (list != null && list.size() > 0) {
                    return list.get(0);
                } else {
                    return null;
                }
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        return null;
    }

    public static Object findEntityForFieldNoStatus(Object entity, String fieldOfEntity, int valueOfField) {
        EntityManager em = null;
        String name = extractName(entity);
        if ((name != null) && (!name.isEmpty())) {
            try {
                em = getEntityManager();
//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE l." + fieldOfEntity + "= :field1");
                qw.setParameter("field1", valueOfField);
                // qw.setParameter("status", "Removed");
                List list = qw.getResultList();


                if ((list == null) || (list.size() < 1)) {
                    return null;
                } else {
                    return list.get(0);
                }

            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        return null;
    }

    public static Object findEntityForField(Object entity, String fieldOfEntity, int valueOfField, boolean all) {
        EntityManager em = null;
        String name = extractName(entity);
        if ((name != null) && (!name.isEmpty())) {
            try {
                em = getEntityManager();
//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE l." + fieldOfEntity + "= :field1 and l.status <> :status");
                qw.setParameter("field1", valueOfField);
                qw.setParameter("status", "Removed");
                List list = qw.getResultList();


                if ((list == null) || (list.size() < 1)) {
                    return null;
                }
                if (!all) {
                    return list.get(0);
                } else {
                    return list;
                }

            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        return null;
    }

    public static Object findEntityForField2(Object entity, String fieldOfEntity, int valueOfField, boolean all) {
        EntityManager em = null;
        String name = extractName(entity);
        if ((name != null) && (!name.isEmpty())) {
            try {
                em = getEntityManager();
//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE l." + fieldOfEntity + "= :field1 and l.status <> :status ORDER BY l.orderQuestion,l.id");
                qw.setParameter("field1", valueOfField);
                qw.setParameter("status", "Removed");
                List list = qw.getResultList();


                if ((list == null) || (list.size() < 1)) {
                    return null;
                }
                if (!all) {
                    return list.get(0);
                } else {
                    return list;
                }

            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        return null;
    }

    public static Object findEntityForField22(Object entity, String fieldOfEntity, int valueOfField, boolean all) {
        EntityManager em = null;
        String name = extractName(entity);
        if ((name != null) && (!name.isEmpty())) {
            try {
                em = getEntityManager();
//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE l." + fieldOfEntity + "= :field1 and l.status <> :status ORDER BY l.orderAnswer,l.id");
                qw.setParameter("field1", valueOfField);
                qw.setParameter("status", "Removed");
                List list = qw.getResultList();


                if ((list == null) || (list.size() < 1)) {
                    return null;
                }
                if (!all) {
                    return list.get(0);
                } else {
                    return list;
                }

            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        return null;
    }

    public static Object findEntityForField(Object entity, String fieldOfEntity, String valueOfField, boolean all) {
        EntityManager em = null;
        String name = extractName(entity);
        if ((name != null) && (!name.isEmpty())) {
            try {
                em = getEntityManager();
//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE l." + fieldOfEntity + "= :field1 and l.status <> :status");
                qw.setParameter("field1", valueOfField);
                qw.setParameter("status", "Removed");
                List list = qw.getResultList();


                if ((list == null) || (list.size() < 1)) {
                    return null;
                }
                if (!all) {
                    return list.get(0);
                } else {
                    return list;
                }

            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        return null;
    }

    public static Object findEntityForFieldOrOtherField(Object entity, String fieldOfEntity, String fieldOfEntity2, String valueOfField, boolean all) {
        EntityManager em = null;
        String name = extractName(entity);
        if ((name != null) && (!name.isEmpty())) {
            try {
                em = getEntityManager();
//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE (l." + fieldOfEntity + "= :field1 or l." + fieldOfEntity2 + "= :field2) and l.status <> :status");
                qw.setParameter("field1", valueOfField);
                qw.setParameter("field2", valueOfField);
                qw.setParameter("status", "Removed");
                List list = qw.getResultList();


                if ((list == null) || (list.size() < 1)) {
                    return null;
                }
                if (!all) {
                    return list.get(0);
                } else {
                    return list;
                }

            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        return null;
    }

    public static Object findEntityForFieldX(Object entity, String fieldOfEntity, String valueOfField, String field2OfEntity, int valueOfField2) {
        EntityManager em = null;
        String name = extractName(entity);
        if ((name != null) && (!name.isEmpty())) {
            try {
                em = getEntityManager();
//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE l." + fieldOfEntity + "= :field1 and l." + field2OfEntity + "= :field2 and l.status <> :status ORDER BY l.dateCreation DESC");
                qw.setParameter("field1", valueOfField);
                qw.setParameter("field2", valueOfField2);
                qw.setParameter("status", "Removed");
                List list = qw.getResultList();


                if ((list == null) || (list.size() < 1)) {
                    return null;
                }
                return list.get(0);

            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        return null;
    }

    /**
     * 
     * @param entity
     * @return 
     */
    public static boolean deactivate(Object entity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Object participant = entity.getClass().newInstance();
            if (extractId(entity) == -1) {
                return false;
            }
            participant = em.getReference(entity.getClass(), extractId(entity));
            setStatusToEntity(participant, REMOVED);
            //participant.setStatus(JpaUtils.REMOVED);
            participant = em.merge(participant);

            em.getTransaction().commit();


        } catch (InstantiationException ex) {
            //throw new Exception("The participant with id " + id + " no longer exists.", enfe);
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);


            return false;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);


            return false;
        } catch (EntityNotFoundException ex) {
            // throw new NonexistentEntityException("The participant with id " + id + " no longer exists.", enfe);
            Logger.getLogger(JpaUtils.class.getName()).log(Level.SEVERE, null, ex);


            return false;
        } finally {
            //System.out.println("Disabled finally");
            if (em != null) {
                em.close();
            }
        }
        return true;
    }

    public static List findAllEntities(Object entity) {
        EntityManager em = null;
        String name = extractName(entity);
        if ((name != null) && (!name.isEmpty())) {
            try {
                em = getEntityManager();
//                System.out.println("name:" + name);
                Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE l.status <> :status");
                qw.setParameter("status", "Removed");
                List list = qw.getResultList();
//                for (int i = 0; i < list.size(); i++) {
//                    Session p = (Session) list.get(i);
//                    if (p.getId().intValue() == 581) {
//                        p.getDateSince().toString();
//                        System.out.println(p.getDateSince().toString());
//                    }
//                }
                return list;
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }
        return null;
    }

    /**
     * 
     * @param primaryEntity   [entidad primaria] la que contiene el id por el cual queremos consultar la entidad secundaria
     * @param secondaryEntity [entidad secundaria], entidad que se consultara para tomar sus datos
     * @param attachEntity    [entidad de unión] entidad que une a la entidad primaria con la entidad secundaria
     * @param idAttachPE       nombre del id de union con la entidad primaria, en la entidad de union
     * @param idAttachSE       nombre del id de union con la entidad secundaria, en la entidad de union
     * @param primaryEntityId  valor del id de la entidad primaria por el cual consultaremos
     * @return 
     */
    public static List findEntitiesForFieldByAttach(Object primaryEntity, Object secondaryEntity, Object attachEntity, String idAttachPE, String idAttachSE, int primaryEntityId) {
        EntityManager em = null;
        String primaryEntityName = extractName(primaryEntity);
        String secondaryEntityName = extractName(secondaryEntity);
        String attachEntityName = extractName(attachEntity);

        //TODO verificar que los nombres no son nulos

        //if ((name != null) && (!name.isEmpty())) {
        try {
            /*
             * a=lSE
             * sa=lPE
             * sb=SA
             * SELECT * FROM `selectordepruebas`.`participant` a WHERE a.status <>'Removed' and a.id=
             * (SELECT sb.id_participant FROM `selectordepruebas`.`Session` sa,`selectordepruebas`.`inscription` sb
             * 
            WHERE sb.id_Session=sa.id and sb.id_participant=a.id and sa.id=117
            and sa.status <>'Removed' and sb.status <>'Removed');
             */




            //System.out.println("name:" + name);
            //Query qw = em.createQuery("SELECT l FROM " + name + " l WHERE l.id = :id and l.status <> :status");\\

            String queryP = "SELECT lSE FROM " + secondaryEntityName + " lSE WHERE lSE.status <> :lSE_status and lSE.id=";
            String subQuery = "(SELECT SA." + idAttachSE + " FROM " + primaryEntityName + " lPE, " + attachEntityName + " SA";
            subQuery += " WHERE SA." + idAttachPE + "=lPE.id and SA." + idAttachSE + "=lSE.id and lPE.id=" + primaryEntityId;
            subQuery += " and lPE.status<>'Removed' and SA.status <>'Removed')";



            String query = queryP + subQuery;
            //System.out.println("Master query id:" + query);
            Query qw = em.createQuery(query);
            qw.setParameter("lSE_status", "Removed");
//            qw.setParameter(field, fieldValue);
//            qw.setParameter("status", "Removed");
            List list = qw.getResultList();
//                if (list != null && list.size() > 0) {
//                    return list.get(0);
//                }
            return list;
        } catch (Exception ex) {
            System.out.println("ex:[findEntitiesForFieldByAttach] " + ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return new ArrayList();
    }

    public static int getEntityCount(Object entity) {
        EntityManager em = null;
        String entityName = extractName(entity);
        try {
            em = getEntityManager();
            String query = "SELECT l FROM " + entityName + " l WHERE l.status <> :status";
            Query qw = em.createQuery(query);
            qw.setParameter("status", "Removed");

            List list = qw.getResultList();
            return list.size();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
