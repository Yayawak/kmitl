from mysql import connector

conn = connector.connect(
    host="remotemysql.com",
    user="bPHiiRCWTe",
    passwd="Ftl2nnrmAp",
    database="bPHiiRCWTe"
)


print('connected!')
cursor = conn.cursor()

def task1p1():
    sql = """
        select *
        from `characters` c
        left join anime a
        on c.animeFK = a.id
        where a.title like "ka%"
    """
    cursor.execute(sql)
    for x in cursor:
        id = x[0]
        print(id, x[2], sep=" ")
        # print(x)

def task1p2():
    sql_insert = """
        insert into characters (id, fName, lName, popularity, animeFk)
        values (%s, %s, %s, %s, %s)
    """
    val = (509880, "apisit", "thaweboon", 999, 14)
    cursor.execute(sql_insert, val)
    conn.commit()

def task1p3():
    sql_3 = """
        select *
        from characters c
        inner join anime a
        on c.animeFK = a.id
        where c.fName = "apisit"
    """
    cursor.execute(sql_3)
    for x in cursor:
        print(x)

# task1p1()
# task1p2() # Try again you will find error tried to push duplicated primary key to existed record
# task1p3()

conn.close()
