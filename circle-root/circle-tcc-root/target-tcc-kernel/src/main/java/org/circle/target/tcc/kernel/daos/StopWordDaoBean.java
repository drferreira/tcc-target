package org.circle.target.tcc.kernel.daos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;

import org.circle.target.tcc.kernel.StopWord;
import org.circle.target.tcc.kernel.Word;
import org.circle.target.tcc.kernel.exceptions.DataNotFoundException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

@Stateless
public class StopWordDaoBean extends GenericDao implements StopWordDao {

	private static final long serialVersionUID = -6824482957608961500L;

	@Override
	public void save(StopWord stopWord) {
		persist(stopWord);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<StopWord> getAll() {
		Criteria criteria = mountCriteria(StopWord.class,
				new LinkedList<SimpleExpression>());
		return criteria.list();
	}

	@Override
	public StopWord getStopWordByNameWord(Word word) throws DataNotFoundException {
		List<SimpleExpression> expressions = new ArrayList<SimpleExpression>();
		expressions.add(Restrictions.eq("stopWord", word));

		Criteria criteria = mountCriteria(StopWord.class, expressions);
		StopWord stopWord = (StopWord) criteria.uniqueResult();

		if (stopWord != null) {
			
			return stopWord;
		} else {

			throw new DataNotFoundException();
		}

	}

}
