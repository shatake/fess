<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%><tiles:insert template="/WEB-INF/view/common/admin/layout.jsp"
	flush="true">
	<tiles:put name="title">
		<bean:message key="labels.key_match_configuration" />
	</tiles:put>
	<tiles:put name="header" value="/WEB-INF/view/common/admin/header.jsp" />
	<tiles:put name="footer" value="/WEB-INF/view/common/admin/footer.jsp" />
	<tiles:put name="menu" value="/WEB-INF/view/common/admin/menu.jsp" />
	<tiles:put name="menuType" value="keyMatch" />
	<tiles:put name="headerScript" type="string"></tiles:put>
	<tiles:put name="body" type="string">

		<h3>
			<bean:message key="labels.key_match_title_details" />
		</h3>

		<%-- Message: BEGIN --%>
		<div>
			<html:messages id="msg" message="true">
				<div class="alert-message info"><bean:write name="msg" ignore="true" /></div>
			</html:messages>
			<html:errors />
		</div>
		<%-- Message: END --%>

		<%-- List: BEGIN --%>
		<div class="list-table">
			<div>
				<ul class="pills">
					<li class="active"><a href="#"><bean:message
								key="labels.key_match_link_list" /></a></li>
					<li><s:link href="createpage">
							<bean:message key="labels.key_match_link_create_new" />
						</s:link></li>
				</ul>
			</div>
			<c:if test="${keyMatchPager.allRecordCount == 0}">
				<p class="alert-message warning">
					<bean:message key="labels.list_could_not_find_crud_table" />
				</p>
			</c:if>
			<c:if test="${keyMatchPager.allRecordCount > 0}">
				<table class="bordered-table zebra-striped">
					<thead>
						<tr>
							<th style="text-align: center; width: 50px;"><bean:message
									key="labels.key_match_list_term" /></th>
							<th style="text-align: center; width: 200px;"><bean:message
									key="labels.key_match_list_query" /></th>
							<th style="text-align: center; width: 120px;">&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="data" varStatus="s" items="${keyMatchItems}">
							<tr class="${s.index % 2 == 0 ? 'row1' : 'row2'}">
								<td>${f:h(data.term)}</td>
								<td style="overflow-x: auto;">${f:h(data.query)}</td>
								<td style="text-align: center;"><s:link
										href="confirmpage/4/${f:u(data.id)}">
										<bean:message key="labels.key_match_link_details" />
									</s:link> <s:link href="editpage/2/${f:u(data.id)}">
										<bean:message key="labels.key_match_link_edit" />
									</s:link> <s:link href="deletepage/3/${f:u(data.id)}">
										<bean:message key="labels.key_match_link_delete" />
									</s:link></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<%-- Page Navigation: BEGIN --%>
				<div class="row center">
					<div class="pagination">
						<ul>
							<c:if test="${keyMatchPager.existPrePage}">
								<li class="prev"><s:link
										href="list/${keyMatchPager.currentPageNumber - 1}">
										<bean:message key="labels.key_match_link_prev_page" />
									</s:link></li>
							</c:if>
							<c:if test="${!keyMatchPager.existPrePage}">
								<li class="prev disabled"><a href="#"><bean:message
											key="labels.key_match_link_prev_page" /></a></li>
							</c:if>
							<c:forEach var="p" varStatus="s"
								items="${keyMatchPager.pageNumberList}">
								<li
									<c:if test="${p == keyMatchPager.currentPageNumber}">class="active"</c:if>>
									<s:link href="list/${p}">${p}</s:link>
								</li>
							</c:forEach>
							<c:if test="${keyMatchPager.existNextPage}">
								<li class="next"><s:link
										href="list/${keyMatchPager.currentPageNumber + 1}">
										<bean:message key="labels.key_match_link_next_page" />
									</s:link></li>
							</c:if>
							<c:if test="${!keyMatchPager.existNextPage}">
								<li class="next disabled"><a href="#"><bean:message
											key="labels.key_match_link_next_page" /></a></li>
							</c:if>
						</ul>
					</div>

					<div>
						<span><bean:message key="labels.pagination_page_guide_msg"
								arg0="${f:h(keyMatchPager.currentPageNumber)}"
								arg1="${f:h(keyMatchPager.allPageCount)}"
								arg2="${f:h(keyMatchPager.allRecordCount)}" /></span>
					</div>
				</div>
				<%-- Page Navigation: END --%>
			</c:if>
		</div>
		<%-- List: END --%>

	</tiles:put>
</tiles:insert>
