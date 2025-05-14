-- customers
INSERT INTO customers (customer_id, name, year_of_birth, phone, address) VALUES
('c001','Nguyễn Văn A',1985,'0909123456','Hà Nội'),
('c002','Trần Thị B',1992,'0912345678','Hồ Chí Minh'),
('c003','Lê Thị C',1978,'0987654321','Đà Nẵng'),
('c004','Phạm Văn D',2000,'0978123456','Cần Thơ'),
('c005','Võ Thị E',1988,'0965432109','Hải Phòng'),
('c006','Đặng Thị F',1995,'0933123456','Nha Trang'),
('c007','Vũ Văn G',1982,'0944123456','Vũng Tàu'),
('c008','Hoàng Thị H',1975,'0955123456','Huế'),
('c009','Bùi Văn I',1990,'0966123456','Quảng Ninh'),
('c010','Trịnh Thị K',2002,'0977123456','Bình Dương');

-- movies
INSERT INTO movies (movie_id, title, genre, release_year, director, duration) VALUES
('m001','The Matrix','Sci-Fi',1999,'The Wachowskis',136),
('m002','Parasite','Thriller',2019,'Bong Joon-ho',132),
('m003','Inception','Sci-Fi',2010,'Christopher Nolan',148),
('m004','Lion King','Animation',1994,'Roger Allers',88),
('m005','Interstellar','Sci-Fi',2014,'Christopher Nolan',169),
('m006','The Godfather','Crime',1972,'Francis Ford Coppola',175),
('m007','Spirited Away','Animation',2001,'Hayao Miyazaki',125),
('m008','Avengers: Endgame','Action',2019,'Anthony Russo',181);

-- movie_actors
INSERT INTO movie_actors (movie_id, actor) VALUES
('m001','Keanu Reeves'),
('m001','Laurence Fishburne'),
('m002','Song Kang-ho'),
('m002','Cho Yeo-jeong'),
('m003','Leonardo DiCaprio'),
('m003','Ellen Page'),
('m004','Matthew Broderick'),
('m004','James Earl Jones'),
('m005','Matthew McConaughey'),
('m005','Anne Hathaway'),
('m006','Marlon Brando'),
('m006','Al Pacino'),
('m007','Rumi Hiiragi'),
('m007','Miyu Irino'),
('m008','Robert Downey Jr.'),
('m008','Chris Evans'),
('m008','Scarlett Johansson');

-- shows
INSERT INTO shows (show_id, hall_name, show_date_time, movie_id) VALUES
('s001','Hall A','2025-06-01 10:00:00','m001'),
('s002','Hall A','2025-06-01 14:30:00','m003'),
('s003','Hall B','2025-06-02 09:00:00','m002'),
('s004','Hall C','2025-06-02 11:30:00','m004'),
('s005','Hall B','2025-06-02 15:00:00','m003'),
('s006','Hall D','2025-06-03 18:00:00','m005'),
('s007','Hall A','2025-06-03 10:30:00','m006'),
('s008','Hall B','2025-06-03 14:00:00','m007'),
('s009','Hall C','2025-06-03 18:30:00','m008'),
('s010','Hall D','2025-06-04 09:00:00','m006'),
('s011','Hall A','2025-06-04 13:15:00','m007'),
('s012','Hall B','2025-06-04 17:45:00','m008'),
('s013','Hall A', NOW(), 'm002'),
('s014','Hall B', NOW(), 'm004'),
('s015','Hall C', NOW(), 'm005'),
('s016','Hall D', NOW(), 'm007'),
('s017','Hall A', NOW(), 'm008');

-- tickets
INSERT INTO tickets (ticket_number, seat, type, price, booking_date, customer_id, show_id) VALUES
('t0001','A1','VIP',120.0,'2025-05-10','c001','s001'),
('t0002','A2','STANDARD',80.0,'2025-05-11','c002','s001'),
('t0003','B5','VIP',60.0,'2025-05-12','c003','s002'),
('t0004','C3','STANDARD',150.0,'2025-05-12','c001','s002'),
('t0005','D7','VIP',200.0,'2025-05-13','c004','s003'),
('t0006','E1','STANDARD',90.0,'2025-05-14','c002','s004'),
('t0007','F2','VIP',150.0,'2025-05-14','c003','s005'),
('t0008','G4','STANDARD',150.0,'2025-05-14','c001','s005'),
('t0009','H8','VIP',70.0,'2025-05-15','c005','s006'),
('t0010','J3','STANDARD',180.0,'2025-05-15','c004','s006'),
('t0011','K1','VIP',100.0,'2025-05-16','c002','s006'),
('t0012','L4','STANDARD',180.0,'2025-05-16','c005','s006'),
('t0013','M1','VIP',180.0,'2025-05-17','c006','s007'),
('t0014','M2','STANDARD',100.0,'2025-05-17','c007','s007'),
('t0015','N3','VIP',90.0,'2025-05-18','c008','s008'),
('t0016','N4','STANDARD',150.0,'2025-05-18','c009','s008'),
('t0017','O5','VIP',200.0,'2025-05-19','c010','s009'),
('t0018','O6','STANDARD',120.0,'2025-05-19','c001','s009'),
('t0019','P7','VIP',110.0,'2025-05-20','c002','s010'),
('t0020','P8','STANDARD',180.0,'2025-05-20','c003','s010'),
('t0021','Q9','VIP',200.0,'2025-05-21','c004','s011'),
('t0022','Q10','STANDARD',130.0,'2025-05-21','c005','s011'),
('t0023','R11','VIP',120.0,'2025-05-22','c006','s012'),
('t0024','R12','STANDARD',210.0,'2025-05-22','c007','s012'),
('t0025','S13','VIP',140.0,'2025-05-23','c008','s012');

