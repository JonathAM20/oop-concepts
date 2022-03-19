package main.java.core;

import main.java.model.AbstractionLogin;
import main.java.model.GithubLogin;

public class OOPConceptsMain {

	public static void main(String[] args) {
		AbstractionLogin githubLogin = new GithubLogin("admin", "admin");
		githubLogin.login();
	}

}
