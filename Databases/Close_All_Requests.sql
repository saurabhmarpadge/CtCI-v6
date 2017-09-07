UPDATE Requests
SET status = 'Close'
WHERE aptid in (SELECT aptid FROM Apartments where buildingid = 1 )