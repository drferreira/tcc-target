package org.circle.target.tcc.kernel.daos;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;

import org.circle.target.tcc.kernel.TypeStopWord;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

@Stateless
public class TypeStopWordDaoBean extends GenericDao implements TypeStopWordDao {

	private static final long serialVersionUID = -6957504185250806842L;

	
	@Override
	@SuppressWarnings("unchecked")
	public List<TypeStopWord> getAll() {
		
		Criteria criteria = mountCriteria(TypeStopWord.class, new LinkedList<SimpleExpression>());
		return criteria.list();
	}


	@Override
	public TypeStopWord getByName(String value) {
		List<SimpleExpression> expressions = new LinkedList<SimpleExpression>();
		expressions.add(Restrictions.eq("typeName", value));
		
		return (TypeStopWord) mountCriteria(TypeStopWord.class, expressions).uniqueResult();
	}
}
