package ie.cganalytics.clubadmin.dao;

import ie.cganalytics.clubadmin.model.hibernate.ClubImpl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ClubDao extends HibernateDaoSupport {

	public List<ClubImpl> getClubs() {
		return getHibernateTemplate().find("from ClubImpl");
	}
	
	public ClubImpl getClub(Long clubId) {
		List<ClubImpl> clubs = getHibernateTemplate().findByNamedParam(
				"from ClubImpl c where c.id = :id", "id", clubId);
		if (clubs.size() > 0) {
			return clubs.get(0);
		}
		return null;
	}
	
	public void save(ClubImpl club) {
		getHibernateTemplate().saveOrUpdate(club);
	}
	
	public void delete(ClubImpl club) {
		getHibernateTemplate().delete(club);
		
	}
	
	public void delete(Long clubId) {
		ClubImpl club = getClub(clubId);
		if (club != null) {
			getHibernateTemplate().delete(club);
		}
	}
}
