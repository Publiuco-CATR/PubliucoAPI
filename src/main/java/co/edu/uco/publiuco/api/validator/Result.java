package co.edu.uco.publiuco.api.validator;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;

public final class Result {

	private boolean Valid;
	private List<String> messages;
	
	private Result(final List<String> messages) {
		setMessages(messages);
	}

	private final void setMessages(final List<String> messages) {
		this.messages = UtilObject.getDefault(messages, new ArrayList<>());
	}
	
	public static Result create() {
		return new Result(new ArrayList<>());
	}
	
	public static Result create(final List<String> messages) {
		return new Result(messages);
	}
	
	public void addMessage(String message) {
		if (!UtilText.getUtilText().isEmpty(message)) {
			messages.add(UtilText.getUtilText().applyTrim(message));
		}
	}
	
	public final void addMessages(final List<String> messages) {
		getMessages().addAll(UtilObject.getDefault(messages, new ArrayList<>()));
	}
	
	public final List<String> getMessages() {
		return messages;
	}
	
	public final boolean isValid() {
		return messages.isEmpty();
	}
}
