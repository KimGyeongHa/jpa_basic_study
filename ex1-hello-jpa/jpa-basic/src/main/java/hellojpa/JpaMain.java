package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em =  emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

           /* select

                Member findMember = em.find(Member.class,1L );
                System.out.println("id :" +  findMember.getId());
                System.out.println("name : " + findMember.getName());

            */
            
              /* insert

                Member member = new Member();
                member.setId(1L);
                member.setName("HelloA");

                em.persist(member);
                tx.commit();

            */

            /* update

                em.find(Member.class,1L).setName("HelloJPA");
                tx.commit();

            */

            /* delete

                em.remove(em.find(Member.class,1L));

            */

            /* JPQL (Entity 객체대상으로 query) <-> SQL(데이터베이스 테이블 대상으로 query)

                List<Member> result = em.createQuery("select m from Member as m",Member.class)
                        .setFirstResult(1)
                        .setMaxResults(10)
                        .getResultList();

                for(Member member : result){
                    System.out.println("name : " + member.getName());
                }

            */

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
