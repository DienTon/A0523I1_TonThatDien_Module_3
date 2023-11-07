use quanlysinhvien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
SELECT 
    s.SubId,s.SubName, MAX(m.Mark)
FROM
    `subject` s
        JOIN
    mark m ON s.SubId = m.SubId
GROUP BY s.SubId;
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần