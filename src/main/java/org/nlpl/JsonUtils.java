package org.nlpl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.nlpl.Tokenizer.Result.Token;

public class JsonUtils {
	public static String resultToJson(Object o) {
		Tokenizer.Result result = (Tokenizer.Result) o; 
		JSONObject resultJson = new JSONObject();
		JSONArray tokenArray = new JSONArray();
		resultJson.put("tokens", tokenArray);
		resultJson.put("text", result.text);
		for (Token t : result.tokens)
			tokenArray.put(new JSONObject().put("range", new JSONArray().put(t.start).put(t.end))
					.put("lemma", t.lemma).put("details", t.details));
		return resultJson.toString();
	}

}
