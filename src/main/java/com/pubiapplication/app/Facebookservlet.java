package com.pubiapplication.app;

import com.restfb.*;
import com.restfb.types.Page;
import com.restfb.types.User;

public class Facebookservlet {
	private static final String MY_ACCESS_TOKEN = "CAACEdEose0cBAAIOWyYnvK6FDT1sWKTztKIfQtO7bKzOyRZBujlubfjiBNAvp8jx36eXQnsXMWIrwBZAFVEjYj3RYgLZBPM0aYRwGbQ8tZBpiZARdCE7Wj2uAaEUqSBNaDCvZBJwSdsohq7AFrZCUYw28IZC46u7AkhRBWRJOmnEEZBDGmKOpbz95WUeo6PAyr7CNjZAce85Mn8wZDZD";
	FacebookClient facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);
	User user = facebookClient.fetchObject("me", User.class);
	Page page = facebookClient.fetchObject("cocacola", Page.class);

}