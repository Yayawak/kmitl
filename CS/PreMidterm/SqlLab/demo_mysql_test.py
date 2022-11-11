from mysql import connector

conn = connector.connect(
    host="remotemysql.com",
    user="bPHiiRCWTe",
    passwd="Ftl2nnrmAp",
    database="bPHiiRCWTe"
)


print('connected!')
cursor = conn.cursor()

# sql = "select * from characters"
# sql = "select * from anime"
sql = """
select *
    from bPHiiRCWTe.`characters` c
    left join bPHiiRCWTe.anime a
    on c.animeFK = a.id
    where a.title like "ka%"
"""
# cursor.execute(sql)
sql_insert = """
    insert into characters (id, fName, lName, popularity, animeFk)
    values (%s, %s, %s, %s, %s)
"""
val = (509880, "apisit", "thaweboon", 999, 14)
# cursor.execute(sql_insert, val)
# conn.commit()

sql_3 = """
    select *
    from characters c
    inner join anime a
    on c.animeFK = a.id
    where c.fName = "apisit"
"""

cursor.execute(sql_3)
for x in cursor:
    # id = x[0]
    # print(id, x[2], sep=" ")
    # print(x[1], x[2], sep=" ")
    print(x)
    ...
conn.close()
