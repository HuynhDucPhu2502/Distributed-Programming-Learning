
-- Insert data into categories table
INSERT INTO categories (category_id, category_name, description) VALUES('C101','General Knowledge','Test your knowledge on various topics');
INSERT INTO categories (category_id, category_name, description) VALUES('C102','Science','Test your knowledge on scientific concepts');
INSERT INTO categories (category_id, category_name, description) VALUES('C103','History','Test your knowledge on historical events');
INSERT INTO categories (category_id, category_name, description) VALUES('C104','Mathematics','Test your knowledge on mathematical problems');
INSERT INTO categories (category_id, category_name, description) VALUES('C105','Literature','Test your knowledge on famous literary works');
INSERT INTO categories (category_id, category_name, description) VALUES('C106','Geography','Test your knowledge on world geography');
INSERT INTO categories (category_id, category_name, description) VALUES('C107','Music','Test your knowledge on music genres and artists');
INSERT INTO categories (category_id, category_name, description) VALUES('C108','Movies','Test your knowledge on popular movies and actors');
INSERT INTO categories (category_id, category_name, description) VALUES('C109','Sports','Test your knowledge on various sports and athletes');
INSERT INTO categories (category_id, category_name, description) VALUES('C110','Technology','Test your knowledge on latest technology trends');
INSERT INTO categories (category_id, category_name, description) VALUES('C111','Food','Test your knowledge on different cuisines and dishes');
INSERT INTO categories (category_id, category_name, description) VALUES('C112','Fashion','Test your knowledge on fashion trends and designers');
INSERT INTO categories (category_id, category_name, description) VALUES('C113','Art','Test your knowledge on famous artworks and artists');
INSERT INTO categories (category_id, category_name, description) VALUES('C114','Politics','Test your knowledge on political leaders and events');
INSERT INTO categories (category_id, category_name, description) VALUES('C115','Environment','Test your knowledge on environmental issues and conservation');
INSERT INTO categories (category_id, category_name, description) VALUES('C116','Health','Test your knowledge on health and wellness topics');
INSERT INTO categories (category_id, category_name, description) VALUES('C117','Business','Test your knowledge on business concepts and strategies');
INSERT INTO categories (category_id, category_name, description) VALUES('C118','Fashion','Test your knowledge on fashion trends and designers');
INSERT INTO categories (category_id, category_name, description) VALUES('C119','Programming','Test your knowledge on programming languages and concepts');

SELECT * FROM categories;

-- Insert data into quizzes table
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ101','General Knowledge Quiz',10,'C101');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ102','Science Quiz',10,'C102');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ103','History Quiz',10,'C103');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ104','Mathematics Quiz',10,'C104');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ105','Literature Quiz',10,'C105');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ106','Geography Quiz',10,'C106');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ107','Music Quiz',10,'C107');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ108','Movies Quiz',10,'C108');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ109','Sports Quiz',10,'C109');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ110','Technology Quiz',10,'C110');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ111','Food Quiz',10,'C111');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ112','Fashion Quiz',10,'C112');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ113','Art Quiz',10,'C113');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ114','Politics Quiz',10,'C114');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ115','Environment Quiz',10,'C115');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ116','Health Quiz',10,'C116');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ117','Business Quiz',10,'C117');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ118','Fashion Quiz',10,'C118');
INSERT INTO quizzes (quiz_id, title, score, category_id) VALUES('QZ119','Programming Quiz',10,'C110');


SELECT * FROM quizzes;

-- Insert data into questions table

-- Insert 11 questions for 'Movies Quiz'
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('Q131','MULTIPLE_CHOICE','EASY','Who directed the movie "The Shawshank Redemption"?', 'C108');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('Q132','TRUE_FALSE','MEDIUM','The movie "Forrest Gump" was released in 1994.', 'C108');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('Q133','FILL_IN_THE_BLANK','HARD','The character of James Bond is based on the novels by Ian Fleming.', 'C108');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('Q134','MATCHING','EASY','Match the following actors with their famous roles.', 'C108');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('Q135','ESSAY','HARD','Discuss the impact of the movie "Titanic" on popular culture.', 'C108');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('Q136','MULTIPLE_CHOICE','MEDIUM','Who won the Academy Award for Best Actor in 2019?', 'C108');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('Q137','TRUE_FALSE','EASY','The movie "The Godfather" was directed by Martin Scorsese.', 'C108');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('Q138','FILL_IN_THE_BLANK','HARD','The highest-grossing movie of all time is "Avatar".' , 'C108');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('Q139','MATCHING','MEDIUM','Match the following movie quotes with their corresponding films.', 'C108');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('Q140','ESSAY','HARD','Analyze the cinematography of the movie "Inception".' , 'C108');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('Q141','MULTIPLE_CHOICE','EASY','Which movie won the Academy Award for Best Picture in 2020?', 'C108');

-- Insert 10 questions for 'Programming Quiz'
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QP202','TRUE_FALSE','MEDIUM','Java is a low-level programming language.', 'C119');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QP203','MULTIPLE_CHOICE','EASY','Which of the following is a programming language?', 'C119');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QP204','FILL_IN_THE_BLANK','HARD','The process of finding and fixing errors in a program is called __________.', 'C119');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QP205','MATCHING','EASY','Match the programming language with its primary use.', 'C119');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QP206','ESSAY','HARD','Discuss the importance of algorithms in computer programming.', 'C119');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QP207','TRUE_FALSE','EASY','Python is a compiled programming language.', 'C119');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QP208','MULTIPLE_CHOICE','MEDIUM','Which of the following is an object-oriented programming language?', 'C119');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QP209','FILL_IN_THE_BLANK','HARD','A collection of data that is stored in memory is called a __________.', 'C119');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QP210','MATCHING','MEDIUM','Match the programming concept with its definition.', 'C119');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QP211','ESSAY','HARD','Explain the difference between procedural and object-oriented programming.', 'C119');

-- Insert 10 questions for 'History'
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QH301','TRUE_FALSE','MEDIUM','The French Revolution took place in the 19th century.', 'C103');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QH302','MULTIPLE_CHOICE','EASY','Who was the first President of the United States?', 'C103');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QH303','FILL_IN_THE_BLANK','HARD','The Magna Carta was signed in the year __________.', 'C103');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QH304','MATCHING','EASY','Match the historical event with the correct date.', 'C103');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QH305','ESSAY','HARD','Analyze the impact of World War II on global politics.', 'C103');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QH306','TRUE_FALSE','EASY','The Industrial Revolution began in the 18th century.', 'C103');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QH307','MULTIPLE_CHOICE','MEDIUM','What year did the Berlin Wall fall?', 'C103');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QH308','FILL_IN_THE_BLANK','HARD','The Battle of Hastings took place in the year __________.', 'C103');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QH309','MATCHING','MEDIUM','Match the historical figure with their contribution.', 'C103');
INSERT INTO questions (question_id, type, question_level, question_text, category_id) VALUES('QH310','ESSAY','HARD','Discuss the causes and consequences of the American Civil War.', 'C103');




SELECT * FROM questions;

-- Insert data into answers table

-- Answer for questions Q131 to Q141
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A131A','Frank Darabont',1,'Q131'); 
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A131B','Steven Spielberg',0,'Q131');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A131C','Quentin Tarantino',0,'Q131');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A131D','Martin Scorsese',0,'Q131');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A132A','True',1,'Q132');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A132B','False',0,'Q132');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A133A','Ian Fleming',1,'Q133');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A133B','Agatha Christie',0,'Q133');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A133C','Arthur Conan Doyle',0,'Q133');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A133D','J.K. Rowling',0,'Q133');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A134A','Tom Hanks',1,'Q134');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A134B','Leonardo DiCaprio',0,'Q134');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A134C','Brad Pitt',0,'Q134');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A134D','Johnny Depp',0,'Q134');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A135A','James Cameron',1,'Q135');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A135B','Steven Spielberg',0,'Q135');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A135C','Christopher Nolan',0,'Q135');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A135D','Quentin Tarantino',0,'Q135');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A136A','Rami Malek',1,'Q136');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A136B','Bradley Cooper',0,'Q136');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A136C','Christian Bale',0,'Q136');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A136D','Leonardo DiCaprio',0,'Q136');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A137A','False',1,'Q137');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A137B','True',0,'Q137');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A138A','Avatar',1,'Q138');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A138B','Titanic',0,'Q138');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A138C','Avengers: Endgame',0,'Q138');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A138D','Star Wars: The Force Awakens',0,'Q138');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A139A','"May the Force be with you." - Star Wars',1,'Q139');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A139B','"I''ll be back." - The Terminator',0,'Q139');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A139C','"Here''s looking at you, kid." - Casablanca',0,'Q139');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A139D','"You can''t handle the truth!" - A Few Good',0,'Q139');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A140A','Inception is known for its mind-bending visuals and innovative storytelling techniques.',1,'Q140');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A140B','Inception is a science fiction film directed by Christopher Nolan.',0,'Q140');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A140C','Inception explores the concept of dreams within dreams and the subconscious mind.',0,'Q140');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A140D','Inception features an ensemble cast led by Leonardo DiCaprio.',0,'Q140');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A141A','Parasite',1,'Q141');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A141B','Joker',0,'Q141');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A141C','1917',0,'Q141');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('A141D','The Shape of Water',0,'Q141');

-- Answer for questions Q202 to Q211
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP202A','True',1,'QP202');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP202B','False',0,'QP202');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP203A','Java',1,'QP203');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP203B','HTML',0,'QP203');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP203C','CSS',0,'QP203');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP203D','SQL',0,'QP203');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP204A','Debugging',1,'QP204');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP204B','Compiling',0,'QP204');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP204C','Testing',0,'QP204');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP204D','Refactoring',0,'QP204');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP205A','Java - Web Development',1,'QP205');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP205B','Python - Data Science',0,'QP205');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP205C','C++ - Game Development',0,'QP205');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP205D','JavaScript - Frontend Development',0,'QP205');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP206A','Algorithms are essential for solving complex problems efficiently.',1,'QP206');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP206B','Algorithms are used to create user interfaces.',0,'QP206');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP206C','Algorithms are only relevant in academic settings.',0,'QP206');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP206D','Algorithms are not used in modern programming.',0,'QP206');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP207A','False',1,'QP207');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP207B','True',0,'QP207');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP208A','Java',1,'QP208');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP208B','HTML',0,'QP208');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP208C','CSS',0,'QP208');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP208D','SQL',0,'QP208');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP209A','Variable',1,'QP209');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP209B','Function',0,'QP209');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP209C','Class',0,'QP209');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP209D','Object',0,'QP209');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP210A','Abstraction - Hiding complexity',1,'QP210');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP210B','Inheritance - Reusing code',0,'QP210');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP210C','Polymorphism - Overriding methods',0,'QP210');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP210D','Encapsulation - Data protection',0,'QP210');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP211A','Procedural programming focuses on procedures and functions.',1,'QP211');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP211B','Object-oriented programming focuses on objects and classes.',0,'QP211');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP211C','Procedural programming is more efficient than object-oriented programming.',0,'QP211');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AP211D','Object-oriented programming is outdated.',0,'QP211');

-- Answer for questions QH301 to QH310
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH301A','False',1,'QH301');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH301B','True',0,'QH301');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH302A','George Washington',1,'QH302');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH302B','Thomas Jefferson',0,'QH302');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH302C','John Adams',0,'QH302');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH302D','James Madison',0,'QH302');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH303A','1215',1,'QH303');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH303B','1066',0,'QH303');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH303C','1776',0,'QH303');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH303D','1492',0,'QH303');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH304A','French Revolution - 1789',1,'QH304');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH304B','American Revolution - 1776',0,'QH304');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH304C','Russian Revolution - 1917',0,'QH304');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH304D','Industrial Revolution - 18th century',0,'QH304');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH305A','World War II had a lasting impact on global politics and international relations.',1,'QH305');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH305B','World War II was a brief conflict with limited consequences.',0,'QH305');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH305C','World War II had no impact on the world.',0,'QH305');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH305D','World War II was a fictional event.',0,'QH305');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH306A','True',1,'QH306');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH306B','False',0,'QH306');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH307A','1989',1,'QH307');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH307B','1991',0,'QH307');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH307C','1995',0,'QH307');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH307D','2001',0,'QH307');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH308A','1066',1,'QH308');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH308B','1215',0,'QH308');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH308C','1776',0,'QH308');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH308D','1492',0,'QH308');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH309A','Nelson Mandela - Anti-Apar', 1,'QH309');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH309B','Marie Curie - Radioactivity',0,'QH309');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH309C','Leonardo da Vinci - Mona Lisa',0,'QH309');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH309D','Isaac Newton - Laws of Motion',0,'QH309');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH310A','The American Civil War was fought between the Northern states (Union) and the Southern states (Confederacy).',1,'QH310');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH310B','The American Civil War was a conflict between the United States and Mexico.',0,'QH310');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH310C','The American Civil War was a peaceful negotiation between the North and South.',0,'QH310');
INSERT INTO answers (answer_id, answer_text, is_correct, question_id) VALUES('AH310D','The American Civil War was a fictional event.',0,'QH310');

-- Insert data into quizzes_questions table
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ108','Q131');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ108','Q132');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ108','Q133');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ108','Q134');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ108','Q135');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ108','Q136');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ108','Q137');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ108','Q138');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ108','Q139');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ108','Q140');

INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ119', 'QP202');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ119', 'QP203');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ119', 'QP204');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ119', 'QP205');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ119', 'QP206');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ119', 'QP207');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ119', 'QP208');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ119', 'QP209');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ119', 'QP210');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ119', 'QP211');

INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ103', 'QH301');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ103', 'QH302');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ103', 'QH303');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ103', 'QH304');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ103', 'QH305');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ103', 'QH306');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ103', 'QH307');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ103', 'QH308');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ103', 'QH309');
INSERT INTO quizzes_questions (quiz_id, question_id) VALUES('QZ103', 'QH310');

SELECT * FROM quizzes_questions;


SELECT * FROM categories;
SELECT * FROM quizzes;
SELECT * FROM questions;
SELECT * FROM answers;
SELECT * FROM quizzes_questions;

