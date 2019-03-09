package challenge;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	private Integer generateRamdomId(Integer max) {
		Random r = new Random();
		if (max > 0) {
			return r.nextInt(max);
		}
		return 0;
	}

	@Override
	public Quote getQuote() {
		return this.repository.findById(generateRamdomId((int) repository.count())).orElse(null);
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> listQuotes = repository.findByActor(actor);
		return listQuotes.get(generateRamdomId(listQuotes.size()));
	}

}
