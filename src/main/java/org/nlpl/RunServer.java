package org.nlpl;

import static spark.Spark.after;
import static spark.Spark.post;

import java.util.Properties;

import org.nlpl.tokenizers.JapaneseTokenizer;
import org.nlpl.tokenizers.VietTokenizer;

public class RunServer {

	public static void main(String[] args) {
		System.out.println("Loading Vietnamese");
		VietTokenizer vt = new VietTokenizer(new Properties());//TODO need correct config file
		System.out.println("Loading Japanese...");
		JapaneseTokenizer jt = new JapaneseTokenizer("TODO NEED CONFIG FILE HERE");//TODO
		post("/tokenize/vn", (req, res) -> {
			return vt.tokenize(req.body());
		}, JsonUtils::resultToJson);
		post("/tokenize/ja", (req, res) -> {
			return jt.tokenize(req.body());
		}, JsonUtils::resultToJson);
		after((req, res) -> {
			res.type("application/json");
		});
	}

}