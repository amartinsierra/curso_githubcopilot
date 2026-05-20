package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.model.Item;
import init.repository.ItemsRepository;
@Service
public class BuscadorServiceImpl implements BuscadorService {
	
	private final ItemsRepository itemsRepository;	
	
	public BuscadorServiceImpl(ItemsRepository itemsRepository) {
		this.itemsRepository = itemsRepository;
	}

	@Override
	public List<Item> buscarPorTematica(String tematica) {
		return itemsRepository.findByTematica(tematica);
	}
	@Override
	public Boolean nuevoItem(Item item) {
		if(itemsRepository.findFirstByUrl(item.getUrl()).isEmpty()) {
			itemsRepository.save(item);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	@Override
	public void eliminarPorTematica(String tematica) {
		if(itemsRepository.countByTematica(tematica)>0L) {
			itemsRepository.deleteByTematica(tematica);
		}
		
	}

}