package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
/**
 * 
 * @author 
 * Doãn Trần Tuấn Đạt - 16035741
 * Ngô Tuấn Kiệt      - 16044771
 *
 */
public abstract class GeneralCRUD<T> {
	protected EntityManager manager;

	public GeneralCRUD() {
		manager = MyEntityManagerFactory.getInstance().getEntityManager(); 
	}
	
	protected void flushAndClear() {
		manager.flush();
		manager.clear();
	}
	
	public boolean Them (T t) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(t);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
		}

		return false;
	}
	public boolean Sua (T t) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(t);
			flushAndClear();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
		}
		
		return false;
	}
	public boolean Xoa (T t) {
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.remove(t);
			flushAndClear();
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
		}
		
		return false;
	}
	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> t) {
		return manager.createQuery("From " + t.getSimpleName()).getResultList();
	}
	
}
