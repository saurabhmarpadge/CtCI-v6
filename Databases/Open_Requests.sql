select Buildings.buildingname, isNULL([Count],0) as [Count]
from Buildings left join 
(   select Apartments.buildingid,COUNT(*) as [Count]
	from Apartments inner join Requests
	on Apartments.aptid = Requests.aptid
	where Requests.status = 'Open'
	Group by Apartments.buildingid
) as T on Buildings.buildingid = T.buildingid