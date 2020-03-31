package tw.leonchen.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService {

	@Autowired
	private PictureDAO pDao;

	public PictureService(PictureDAO pDao) {
      this.pDao = pDao;
	}
	
	public Picture insert(Picture pBean) {
		return pDao.insert(pBean);
	}

}
