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

            /* insert

                Member member = new Member();
                member.setId(1L);
                member.setName("HelloA");

                em.persist(member);
                tx.commit();

            */


                Member findMember = em.find(Member.class,1L );
                System.out.println("id :" +  findMember.getId());
                System.out.println("name : " + findMember.getName());



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


            /* flush
            * 영속성 컨텍스트의 변경내용을 데이터베이스에 동기화
            * */

            /* detach
            * 준영속 상태로 전환
            * */

            /* clear
            * 영속성 컨텍스트 전체를 초기화
            **/

            /* close
            * 영속성 컨텍스트 종료
            **/

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
