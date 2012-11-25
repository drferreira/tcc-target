package org.circle.target.tcc.kernel.daos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.circle.target.tcc.kernel.Word;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

@Stateless
public class WordDaoBean extends GenericDao implements WordDao {

	private static final long serialVersionUID = -8416224414489393646L;


	@Override
	public Word getWord(String value){
		List<SimpleExpression> listExpressions = new ArrayList<SimpleExpression>();
		listExpressions.add(Restrictions.eq("value", value));
		
		Criteria criteria = mountCriteria(Word.class, listExpressions);
		
		return (Word) criteria.uniqueResult();
	}
}
