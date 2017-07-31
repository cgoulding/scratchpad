package ie.cganalytics.clubadmin.dao;

import ie.cganalytics.clubadmin.model.database.Database;
import ie.cganalytics.clubadmin.model.hibernate.ClubImpl;

import java.util.List;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class ClubDaoTest extends AbstractDependencyInjectionSpringContextTests {
	
	ClubDao clubDao = null;
	Database database = null;
	
	public void onSetUp() throws Exception {
		database.create();
	}
	
	public void testGetClubs() {
		List<ClubImpl> clubs = clubDao.getClubs();
		assertEquals(2, clubs.size());
	}
	
	public void testGetClub() {
		ClubImpl club1 = clubDao.getClub(1L);
		assertEquals("SHAMROCKS", club1.getName());
		
		ClubImpl club2 = clubDao.getClub(2L);
		assertEquals("TALLOW", club2.getName());
	}
	
	public void testSave() {
		ClubImpl club = clubDao.getClub(1L);
		assertEquals("SHAMROCKS", club.getName());
		
		club.setName("SHC");
		clubDao.save(club);
		
		club = clubDao.getClub(1L);
		assertEquals("SHC", club.getName());
	}
	
	public void testSaveNew() {
		ClubImpl club = new ClubImpl();
		club.setId(3L);
		club.setName("NEW");
		
		clubDao.save(club);
		
		club = clubDao.getClub(3L);
		assertEquals("NEW", club.getName());
	}
	
	public void testDelete() {
		ClubImpl club = clubDao.getClub(1L);
		assertNotNull(club);
		clubDao.delete(club);
		assertNull(clubDao.getClub(1L));
	}

	public void testDeleteById() {
		clubDao.delete(1L);
		assertNull(clubDao.getClub(1L));
	}
	
	public void setClubDao(ClubDao clubDao) {
		this.clubDao = clubDao;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	public String[] getConfigLocations() {
		return new String[]{"META-INF/spring/test-context.xml"};
	}
}
