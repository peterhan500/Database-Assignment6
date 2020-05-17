CREATE TABLE author
(
	firstName VARCHAR(100) NOT NULL,
	lastName VARCHAR(100) NOT NULL,
	emailAddr VARCHAR(100) NOT NULL,
	PRIMARY KEY (emailAddr)
);

INSERT IGNORE INTO author (firstName, lastName, emailAddr) VALUES
('Mike', 'Black', '1234@email.com'),
('Amy', 'White', '5678@email.com'),
('John', 'Brown', '9876@email.com');
('Jill', 'Red', '3745@email.com');

CREATE TABLE paper
(
	id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    abstraction VARCHAR(100) NOT NULL,
    fileName VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

INSERT IGNORE INTO paper (id, title, abstraction, fileName) VALUES
('123', 'the Development of Computer Science', 'Abstraction', '123paper');
('456', 'the Development of Database Management System', 'Abstraction2', '456paper');

CREATE TABLE reviewer
(
	firstName VARCHAR(100) NOT NULL,
	lastName VARCHAR(100) NOT NULL,
	phoneNum INT NOT NULL,
	emailAddr VARCHAR(100) NOT NULL,
	affiliation VARCHAR(100) NOT NULL,
	authorFeedback VARCHAR(200) NOT NULL,
	commiteeFeedback VARCHAR(200) NOT NULL,
	PRIMARY KEY (emailAddr)
);

INSERT IGNORE INTO reviewer (firstName, lastName, phoneNum, emailAddr, affiliation, authorFeedback, commiteeFeedback) VALUES
('David', 'Blue', '987654321', '7654@email.com', 'Company A', 'AFeedback 1', 'CFeedback A'),
('Kate', 'Green', '364834395', '5390@email.com', 'Company A', 'AFeedback 2', 'CFeedback B');

CREATE TABLE topic
(
	id INT NOT NULL AUTO_INCREMENT,
	topicName VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
);

INSERT IGNORE INTO topic (id, topicName) VALUES
('1', 'topicName 1'),
('2', 'topicName 2');

CREATE TABLE review
(
	id INT NOT NULL,
	paperId INT NOT NULL,
	reviewerId INT NOT NULL, 
	meritScore INT NOT NULL,
	readabilityScore INT NOT NULL,
	originalityScore INT NOT NULL,
	relevanceScore INT NOT NULL,
	recommendation VARCHAR(200) NOT NULL,
	PRIMARY KEY (id)
);

INSERT IGNORE INTO review (id, paperId, reviewerId, meritScore, readabilityScore, originalityScore, relevanceScore, recommendation) VALUES
('1', '123', '1', '8', '7', '9', '10', 'Recommendation1'),
('2', '123', '2', '7', '8', '10', '9', 'Recommendation2');