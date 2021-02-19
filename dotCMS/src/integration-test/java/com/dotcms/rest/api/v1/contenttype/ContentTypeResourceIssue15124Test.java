package com.dotcms.rest.api.v1.contenttype;

import static com.dotcms.rest.api.v1.contenttype.ContentTypeResourceTest.getHttpRequest;

import com.dotcms.rest.EmptyHttpResponse;
import com.dotcms.rest.ResponseEntityView;
import com.dotcms.rest.RestUtilTest;
import com.dotcms.util.IntegrationTestInitService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import org.junit.BeforeClass;
import org.junit.Test;

public class ContentTypeResourceIssue15124Test {

    private static String JSON_OFFENDING_CONTENT_TYPE_CREATE = "{\n"
            + "      \"owner\":\"dotcms.org.2767\",\n"
            + "      \"multilingualable\":false,\n"
            + "      \"modDate\":1534354654000,\n"
            + "      \"versionable\":true,\n"
            + "      \"workflows\":[\n"
            + "         {\n"
            + "            \"id\":\"d61a59e1-a49c-46f2-a929-db2b4bfa88b2\",\n"
            + "            \"creationDate\":1534528890773,\n"
            + "            \"name\":\"System Workflow\",\n"
            + "            \"description\":\"\",\n"
            + "            \"archived\":false,\n"
            + "            \"mandatory\":false,\n"
            + "            \"defaultScheme\":false,\n"
            + "            \"modDate\":1534355202682,\n"
            + "            \"entryActionId\":null,\n"
            + "            \"system\":true\n"
            + "         }\n"
            + "      ],\n"
            + "      \"defaultType\":false,\n"
            + "      \"baseType\":\"CONTENT\",\n"
            + "      \"urlMapPattern\":\"/codeshare/{urlTitle}\",\n"
            + "      \"system\":false,\n"
            + "      \"folder\":\"SYSTEM_FOLDER\",\n"
            + "      \"name\":\"CodeShare\",\n"
            + "      \"variable\":\"Codeshare\",\n"
            + "      \"host\":\"SYSTEM_HOST\",\n"
            + "      \"detailPage\":\"b334b5eb-f371-4014-9921-403023d59a1e\",\n"
            + "      \"fixed\":false,\n"
            + "      \"id\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "      \"fields\":[\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":true,\n"
            + "            \"dataType\":\"TEXT\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":true,\n"
            + "            \"required\":true,\n"
            + "            \"listed\":true,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":1,\n"
            + "            \"name\":\"Title\",\n"
            + "            \"variable\":\"title\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"7eda08c0-26e1-4526-82ca-f6a3d4837100\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableTextField\",\n"
            + "            \"iDate\":1316614846000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":true,\n"
            + "            \"dataType\":\"LONG_TEXT\",\n"
            + "            \"values\":\"<script>\\r\\n\\r\\n\\tfunction updateDisplayURLTitle(){\\r\\n\\t\\t\\r\\n\\t\\t// get the title entered by the user\\r\\n\\t\\tvar plainTitle = dojo.byId(\\\"title\\\");\\t\\r\\n\\t\\t\\r\\n\\t\\t// make a friendly url\\r\\n\\t\\tvar urlTitle = plainTitle.value.toLowerCase();\\r\\n\\t\\turlTitle= urlTitle.replace(/^\\\\s+|\\\\s+$/g,\\\"\\\");\\r\\n\\t\\turlTitle = urlTitle.replace(/[^a-zA-Z 0-9]+/g,' ');\\t\\r\\n\\t\\turlTitle = urlTitle.replace(/\\\\s/g, \\\"-\\\");\\r\\n\\t\\twhile(urlTitle.indexOf(\\\"--\\\") > -1){\\r\\n\\t\\t\\turlTitle = urlTitle.replace(\\\"--\\\",'-');\\t\\r\\n\\t\\t}\\r\\n\\t\\r\\n\\t\\t// set the values of the display place holder and the custom field\\r\\n\\t\\t// the   is to hold the div open\\r\\n\\t\\tdojo.byId(\\\"displayURLTitle\\\").innerHTML = urlTitle;\\r\\n\\t\\tdojo.byId(\\\"urlTitle\\\").value=urlTitle;\\r\\n\\t}\\r\\n\\r\\n\\t// attach this the text1 field onchange\\r\\n\\tdojo.connect(dojo.byId(\\\"headerline\\\"), \\\"onchange\\\", null, \\\"updateDisplayURLTitle\\\");\\r\\n\\t\\r\\n\\t// populate the field on load\\r\\n\\tdojo.addOnLoad(updateDisplayURLTitle);\\r\\n\\r\\n</script>\\r\\n<div id=\\\"displayURLTitle\\\" style=\\\"height:20px\\\"> </div>\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":true,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":2,\n"
            + "            \"name\":\"URL Title\",\n"
            + "            \"variable\":\"urlTitle\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"2f6a8e6e-5a51-4bd7-a28a-731f959368ad\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableCustomField\",\n"
            + "            \"iDate\":1317908730000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":true,\n"
            + "            \"dataType\":\"SYSTEM\",\n"
            + "            \"values\":\"db02c8dc-a836-4f46-ae8e-7bfaf5bef1e2\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":true,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":3,\n"
            + "            \"name\":\"CodeType\",\n"
            + "            \"variable\":\"codetype\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"9e34a402-4ea5-4d16-a34c-5706e4386592\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableCategoryField\",\n"
            + "            \"iDate\":1316617291000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":true,\n"
            + "            \"dataType\":\"DATE\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":true,\n"
            + "            \"required\":true,\n"
            + "            \"listed\":true,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":4,\n"
            + "            \"name\":\"Date Created\",\n"
            + "            \"variable\":\"dateCreated\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"e6cb1f14-e2c9-4dad-af44-cdcde39a3347\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableDateField\",\n"
            + "            \"iDate\":1328764608000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":true,\n"
            + "            \"dataType\":\"LONG_TEXT\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":false,\n"
            + "            \"required\":true,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":5,\n"
            + "            \"name\":\"Description\",\n"
            + "            \"variable\":\"description\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"8f95740a-9e02-4c68-9a60-8fbf44b31327\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableWysiwygField\",\n"
            + "            \"iDate\":1316614951000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":false,\n"
            + "            \"dataType\":\"TEXT\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":false,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":6,\n"
            + "            \"hint\":\"Link to an example page, video, etc.\",\n"
            + "            \"name\":\"URL Link\",\n"
            + "            \"variable\":\"link\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"8043f80b-4e96-465b-a4ff-d121d3bf3688\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableTextField\",\n"
            + "            \"iDate\":1318538075000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":true,\n"
            + "            \"dataType\":\"SYSTEM\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":true,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":7,\n"
            + "            \"name\":\"Tag\",\n"
            + "            \"variable\":\"tag\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"844c1b94-0a69-4b4f-8a4c-bac9412239bb\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableTagField\",\n"
            + "            \"iDate\":1316615006000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":false,\n"
            + "            \"dataType\":\"SYSTEM\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":false,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":8,\n"
            + "            \"name\":\"Image\",\n"
            + "            \"variable\":\"image\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"c5c0e925-d417-4313-b7af-a776f7a3c1b3\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableBinaryField\",\n"
            + "            \"iDate\":1316632213000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":false,\n"
            + "            \"dataType\":\"SYSTEM\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":false,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":9,\n"
            + "            \"name\":\"Share Your Code\",\n"
            + "            \"variable\":\"shareYourCode\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"d881f1b4-85f6-4d71-9168-8e45c05323ce\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableLineDividerField\",\n"
            + "            \"iDate\":1317420923000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":false,\n"
            + "            \"dataType\":\"LONG_TEXT\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":false,\n"
            + "            \"required\":true,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":10,\n"
            + "            \"name\":\"Code\",\n"
            + "            \"variable\":\"code\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"aa133a31-8c98-4cff-a37d-271b03c335ed\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableTextAreaField\",\n"
            + "            \"iDate\":1316614980000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":false,\n"
            + "            \"dataType\":\"SYSTEM\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":false,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":11,\n"
            + "            \"hint\":\"ancillary materials: css file, helper file, additional doc, etc.\",\n"
            + "            \"name\":\"Attachment\",\n"
            + "            \"variable\":\"attachment\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"7cc58bdb-c250-4954-916d-a64fa350800f\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableBinaryField\",\n"
            + "            \"iDate\":1318538512000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":false,\n"
            + "            \"dataType\":\"SYSTEM\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":false,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":12,\n"
            + "            \"name\":\"Author Info - Optional\",\n"
            + "            \"variable\":\"authorInfoOptional\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"8fcb2d5c-38bd-44cf-ac29-391d638b4f77\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableLineDividerField\",\n"
            + "            \"iDate\":1316631604000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":true,\n"
            + "            \"dataType\":\"TEXT\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":true,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":true,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":13,\n"
            + "            \"name\":\"Author Name\",\n"
            + "            \"variable\":\"authorName\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"8b1c5030-76f7-4c17-8494-fbd09f004da6\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableTextField\",\n"
            + "            \"iDate\":1316631430000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":false,\n"
            + "            \"dataType\":\"SYSTEM\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":false,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":14,\n"
            + "            \"name\":\"Photo\",\n"
            + "            \"variable\":\"photo\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"7da0d9cd-a751-49bf-9cbe-9ac6c265547d\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableBinaryField\",\n"
            + "            \"iDate\":1316631486000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":false,\n"
            + "            \"dataType\":\"TEXT\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":false,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":15,\n"
            + "            \"name\":\"Company \",\n"
            + "            \"variable\":\"company\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"4e3bba28-22c4-4ada-9cb4-4b2f7b647cc1\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableTextField\",\n"
            + "            \"iDate\":1316631742000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":false,\n"
            + "            \"dataType\":\"TEXT\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":false,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":16,\n"
            + "            \"name\":\"Job Title\",\n"
            + "            \"variable\":\"jobTitle\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"e8b786ac-a2b7-4b86-9d97-657e8c9b3ca5\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableTextField\",\n"
            + "            \"iDate\":1316702149000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":true,\n"
            + "            \"dataType\":\"TEXT\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":true,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":true,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":17,\n"
            + "            \"name\":\"Website\",\n"
            + "            \"variable\":\"site\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"7c9e9c98-1cca-4003-855c-c2c7cf1ef630\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableTextField\",\n"
            + "            \"iDate\":1327003312000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":false,\n"
            + "            \"dataType\":\"SYSTEM\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":false,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":18,\n"
            + "            \"name\":\"Are You a Computer?\",\n"
            + "            \"variable\":\"areYouAComputer\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"bcc68c88-96b7-4cf4-9c37-ae576fa951dc\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableLineDividerField\",\n"
            + "            \"iDate\":1317420968000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":false,\n"
            + "            \"dataType\":\"SYSTEM\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":false,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":19,\n"
            + "            \"name\":\"Comments and Ratings\",\n"
            + "            \"variable\":\"commentsAndRatings\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":false,\n"
            + "            \"id\":\"91457c17-4fcf-40b5-ab3d-670bd7eae169\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableTabDividerField\",\n"
            + "            \"iDate\":1510773000000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":true,\n"
            + "            \"defaultValue\":\"0\",\n"
            + "            \"dataType\":\"INTEGER\",\n"
            + "            \"values\":\"0\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":true,\n"
            + "            \"searchable\":true,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":20,\n"
            + "            \"name\":\"CommentsCount\",\n"
            + "            \"variable\":\"commentscount\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":true,\n"
            + "            \"id\":\"4080ffd3-9df5-40f5-9311-83af707ab883\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableTextField\",\n"
            + "            \"iDate\":1317831318000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":true,\n"
            + "            \"defaultValue\":\"5\",\n"
            + "            \"dataType\":\"FLOAT\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":false,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":21,\n"
            + "            \"name\":\"Average Rating\",\n"
            + "            \"variable\":\"averageRating\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":true,\n"
            + "            \"id\":\"712444a0-2731-46be-ba5b-5a842563cac2\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableTextField\",\n"
            + "            \"iDate\":1316721601000\n"
            + "         },\n"
            + "         {\n"
            + "            \"modDate\":1534354654000,\n"
            + "            \"indexed\":true,\n"
            + "            \"dataType\":\"INTEGER\",\n"
            + "            \"contentTypeId\":\"e96da09f-161c-4ea9-bb06-5d7680c3477a\",\n"
            + "            \"readOnly\":false,\n"
            + "            \"searchable\":false,\n"
            + "            \"required\":false,\n"
            + "            \"listed\":false,\n"
            + "            \"unique\":false,\n"
            + "            \"sortOrder\":22,\n"
            + "            \"name\":\"Number Of Votes\",\n"
            + "            \"variable\":\"numberOfVotes\",\n"
            + "            \"fieldVariables\":[\n"
            + "\n"
            + "            ],\n"
            + "            \"fixed\":true,\n"
            + "            \"id\":\"ce51b328-a432-4721-81cc-550a9c1c1054\",\n"
            + "            \"clazz\":\"com.dotcms.contenttype.model.field.ImmutableTextField\",\n"
            + "            \"iDate\":1316721602000\n"
            + "         }\n"
            + "      ],\n"
            + "      \"clazz\":\"com.dotcms.contenttype.model.type.ImmutableSimpleContentType\",\n"
            + "      \"iDate\":1487717349899\n"
            + "   }";

    @BeforeClass
    public static void prepare() throws Exception{
        IntegrationTestInitService.getInstance().init();
    }


    @Test
    public void testMain() throws Exception {

        final ContentTypeResource resource = new ContentTypeResource();
        final ContentTypeForm.ContentTypeFormDeserialize contentTypeFormDeserialize = new ContentTypeForm.ContentTypeFormDeserialize();
        final HttpServletRequest request = getHttpRequest();

        String identifier = null;

        try {
            final Response createTypeResponse = resource.createType(request,  new EmptyHttpResponse(),
                    contentTypeFormDeserialize.buildForm(JSON_OFFENDING_CONTENT_TYPE_CREATE));
            RestUtilTest.verifySuccessResponse(createTypeResponse);

            final ResponseEntityView entityView = ResponseEntityView.class.cast(createTypeResponse.getEntity());
            final List list = (List)entityView.getEntity();
            final Map<String, Object> resultMap = (Map<String, Object>)list.get(0);

            identifier = (String)resultMap.get("id");
            final HttpServletRequest request2 = getHttpRequest();
            final Response getTypeResponse = resource.getType(identifier, request2,  new EmptyHttpResponse(), null, null);
            RestUtilTest.verifySuccessResponse(getTypeResponse);

        }finally{
            if(null != identifier){
                resource.deleteType(
                        identifier, getHttpRequest(),  new EmptyHttpResponse()
                );
            }
        }
    }


}
