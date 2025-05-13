-- 1. Publishers
INSERT INTO publishers (publisher_id, name, address, email, phone) VALUES
('PUB1','O\'Reilly Media','1005 Gravenstein Hwy N, Sebastopol, CA','contact@oreilly.com','+1-800-998-9938'),
('PUB2','Penguin Random House','1745 Broadway, New York, NY','info@penguinrandomhouse.com','+1-212-782-9000'),
('PUB3','HarperCollins','195 Broadway, New York, NY','support@harpercollins.com','+1-212-207-7000'),
('PUB4','Simon & Schuster','1230 Avenue of the Americas, NY','help@simonandschuster.com','+1-212-698-7000'),
('PUB5','Macmillan Publishers','120 Broadway, New York, NY','service@macmillan.com','+1-646-307-5151');

-- 2. People
INSERT INTO people (person_id, last_name, first_name, email, professional_title) VALUES
(1,'Nguyễn','An','an.nguyen@example.com','Software Engineer'),
(2,'Trần','Bình','binh.tran@example.com','Data Scientist'),
(3,'Lê','Chi','chi.le@example.com','Architect'),
(4,'Phạm','Dũng','dung.pham@example.com','Product Manager'),
(5,'Võ','Em','em.vo@example.com','QA Engineer'),
(6,'Hoàng','Giang','giang.hoang@example.com','DevOps Engineer'),
(7,'Đỗ','Hải','hai.do@example.com','Backend Developer'),
(8,'Bùi','Hoa','hoa.bui@example.com','UI/UX Designer'),
(9,'Phan','Khôi','khoi.phan@example.com','Business Analyst'),
(10,'Đặng','Lan','lan.dang@example.com','Project Coordinator');

-- 3. Books
INSERT INTO books (ISBN, name, publish_year, num_of_pages, price, publisher_id) VALUES
('9780134685991','Effective Java',2018,416,45.50,'PUB1'),
('9781491950357','Learning React',2017,350,39.99,'PUB2'),
('9780596009205','Head First Design Patterns',2004,694,49.95,'PUB3'),
('9781617294945','Kotlin in Action',2017,360,44.99,'PUB4'),
('9780132350884','Clean Code',2008,464,42.35,'PUB5'),
('9780596007126','Head First Java',2005,720,55.00,'PUB1'),
('9781492078005','Kotlin Programming',2020,300,37.00,'PUB2'),
('9780134494166','Core Java Volume I',2018,928,54.99,'PUB3'),
('9780262033848','Introduction to Algorithms',2009,1312,80.00,'PUB4'),
('9780131103627','The C Programming Language',1988,272,65.00,'PUB5');

-- 4. Authors
INSERT INTO books_authors (ISBN, author) VALUES
('9780134685991','Joshua Bloch'),
('9781491950357','Alex Banks'),
('9781491950357','Eve Porcello'),
('9780596009205','Eric Freeman'),
('9780596009205','Elisabeth Robson'),
('9781617294945','Dmitry Jemerov'),
('9781617294945','Svetlana Isakova'),
('9780132350884','Robert C. Martin'),
('9780596007126','Kathy Sierra'),
('9780596007126','Bert Bates'),
('9781492078005','Venkat Subramaniam'),
('9780134494166','Cay S. Horstmann'),
('9780134494166','Gary Cornell'),
('9780262033848','Thomas H. Cormen'),
('9780262033848','Charles E. Leiserson'),
('9780262033848','Ronald L. Rivest'),
('9780262033848','Clifford Stein'),
('9780131103627','Brian W. Kernighan'),
('9780131103627','Dennis M. Ritchie');

-- 5. Book Translations
INSERT INTO book_translations (ISBN, language, translate_name) VALUES
('9780134685991','vi','Java Hiệu Quả'),
('9780596009205','vi','Kiến Trúc Mẫu Xuất Sắc'),
('9780132350884','vi','Viết Mã Sạch'),
('9780262033848','vi','Giới Thiệu Thuật Toán'),
('9780131103627','vi','Ngôn Ngữ Lập Trình C');

-- 6. Reviews
INSERT INTO reviews (person_id, ISBN, rating, comment) VALUES
(1,'9780134685991',5,'Rất hữu ích cho Java高手'),
(2,'9780134685991',4,'Nhiều ví dụ thực tiễn'),
(3,'9781491950357',4,'Phù hợp cho React mới bắt đầu'),
(4,'9780596009205',5,'Minh họa sinh động dễ hiểu'),
(5,'9780132350884',5,'Tiêu chuẩn viết code chuyên nghiệp'),
(6,'9781617294945',4,'Giúp hiểu Kotlin sâu sắc'),
(7,'9780262033848',3,'Nội dung hơi nặng lý thuyết'),
(8,'9780131103627',5,'Tài liệu kinh điển cho C'),
(9,'9780134494166',4,'Chi tiết, đầy đủ'),
(10,'9780596007126',5,'Dễ theo dõi cho người mới');
