package com.examples.boot.security.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.examples.boot.security.model.UserAccount;
import com.examples.boot.security.service.SequenceGeneratorService;

@Component
public class UserModelListener extends AbstractMongoEventListener<UserAccount> {

	private SequenceGeneratorService sequenceGenerator;

	@Autowired
	public UserModelListener(SequenceGeneratorService sequenceGenerator) {
		this.sequenceGenerator = sequenceGenerator;
	}

	@Override
	public void onBeforeConvert(BeforeConvertEvent<UserAccount> event) {
		if (event.getSource().getId() < 1) {
			event.getSource().setId(sequenceGenerator.generateSequence(UserAccount.SEQUENCE_NAME));
		}
	}

}