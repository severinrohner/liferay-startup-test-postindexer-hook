package com.clavisit.poc.startuptest.postindexer.hook;

import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

/**
 * Created by sro on 04.01.2017.
 * @author sro
 */
@Component(
	immediate = true,
	property = {
			"indexer.class.name=com.liferay.journal.model.JournalArticle"
	},
	service = IndexerPostProcessor.class
)
public class JournalArticleIndexerPostProcessor implements IndexerPostProcessor {

	private static final Log log = LogFactoryUtil.getLog(
			JournalArticleIndexerPostProcessor.class);
	private JournalArticleLocalService journalArticleLocalService;

	@Override
	public void postProcessContextBooleanFilter(
			BooleanFilter booleanFilter, SearchContext searchContext)
			throws Exception {
		log.info("postProcessContextBooleanFilter");
	}

	/**
	 * @deprecated As of 7.0.0, replaced by {@link
	 *             #postProcessContextBooleanFilter(BooleanFilter,
	 *             SearchContext)}
	 */
	@Deprecated
	@Override
	public void postProcessContextQuery(
			BooleanQuery contextQuery, SearchContext searchContext)
			throws Exception {
		log.info("postProcessContextQuery");
	}

	@Override
	public void postProcessDocument(Document document, Object obj)
			throws Exception {
		log.info("postProcessDocument");
		log.info("Journal Article count: " + journalArticleLocalService.getJournalArticlesCount());
	}

	@Override
	public void postProcessFullQuery(
			BooleanQuery fullQuery, SearchContext searchContext)
			throws Exception {
		log.info("postProcessFullQuery");
	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, BooleanFilter booleanFilter,
			SearchContext searchContext)
			throws Exception {
		log.info("postProcessSearchQuery");
	}

	/**
	 * @deprecated As of 7.0.0, replaced by {@link
	 *             #postProcessSearchQuery(BooleanQuery, BooleanFilter,
	 *             SearchContext)}
	 */
	@Deprecated
	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, SearchContext searchContext)
			throws Exception {

		log.info("postProcessSearchQuery");
	}

	@Override
	public void postProcessSummary(
			Summary summary, Document document, Locale locale, String snippet) {
		log.info("postProcessSummary");
	}

	@Reference(unbind = "-")
	protected void setJournalArticleLocalService(JournalArticleLocalService journalArticleLocalService) {
		this.journalArticleLocalService = journalArticleLocalService;
	}

}