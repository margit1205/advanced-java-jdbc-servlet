package ebooklib.com;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.sql.DriverManager.getConnection;


/**
 * Hello world!
 *
 */
public class App
{


    public static void quearyfunction() throws SQLException {
            // ArrayList<String> result=new ArrayList();

            Connection conn = getConnection("jdbc:mysql://localhost:3306/jdbclibrary","root", "KINGAftab@786");

            String query = "select * from Books";
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(query);
            //  result.add(String.valueOf(set));
            // System.out.println(result);
            while (rset.next()) {
                int id = rset.getInt(1);
                String name = rset.getString(2);
                String auth = rset.getString(3);
                System.out.println(id);
                System.out.println(name);
                System.out.println(auth);
            }
            conn.close();

        }
        public static void insertoperation ( int bookid, String bookname, String author) throws SQLException {
            Connection conn = getConnection("jdbc:mysql://localhost:3306/jdbclibrary","root", "KINGAftab@786");

            String q = "INSERT INTO books( Bookid,Bookname,Author)VALUES(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(q);
            stmt.setInt(1,bookid);
            stmt.setString(2,bookname);
            stmt.setString(3,author);
            stmt.executeUpdate();
            System.out.println("Record inserted try to check Booklist");
            conn.close();


        }

        public  static  void removefun(int bookid) throws SQLException {
            Connection conn = getConnection("jdbc:mysql://localhost:3306/jdbclibrary","root", "KINGAftab@786");
            String query="delete from books where Bookid=?";
            PreparedStatement st=conn.prepareStatement(query);
            st.setInt(1,bookid);
            st.executeUpdate();
            System.out.println("Book deleted from record");
            conn.close();

        }
    public  static  void serchfun(int bookid) throws SQLException {
        Connection conn = getConnection("jdbc:mysql://localhost:3306/jdbclibrary","root", "KINGAftab@786");
        String query="select * from Books where Bookid = ? ";
        PreparedStatement st= conn.prepareStatement(query);
        st.setInt(1,bookid);

        //String bookname=res.getString(2);
        ResultSet res=st.executeQuery();
        while(res.next()) {
            System.out.println("Your searched book is  " + res.getString("bookname"));
        }
       conn.close();


    }


    public static void  main(String[] args) throws SQLException, IOException {


        Scanner scan = new Scanner(System.in);
        System.out.println("Hey welcome to E-Library");
        System.out.println(" Enter operation you want to perform ");
        System.out.println("1.Insert a book");
        System.out.println("2.Delete a book");
        System.out.println("3.Search a book");
        System.out.println("4.List of all books");
        //System.out.println("5.Redo Operation");
        System.out.println("0.To Exit");
        int n = scan.nextInt();


while(n!=0) {
    switch (n) {
        case 1: {
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            Scanner read=new Scanner(System.in);
            System.out.println("Enter book id");
            int bookid = read.nextInt();
            System.out.println("Enter book name");
            String bookname =br.readLine();
            System.out.println("Enter author name");
            String bookauthor = br.readLine();

            insertoperation(bookid, bookname, bookauthor);


            //System.out.println("Hey welcome to E-Library");
            System.out.println("\n");
            System.out.println(" Enter operation you want to perform ");
            System.out.println("1.Insert a book");
            System.out.println("2.Delete a book");
            System.out.println("3.Search a book");
            System.out.println("4.List of all books");
            //System.out.println("5.Redo Operation");
            //System.out.println("0.To Exit");
            n = scan.nextInt();
            break;
        }

        case 2: {
            System.out.println("Enter book id to remove");
            int removeid = scan.nextInt();
            removefun(removeid);
            // System.out.println("Hey welcome to E-Library");

            System.out.println(" Enter operation you want to perform ");
            System.out.println("1.Insert a book");
            System.out.println("2.Delete a book");
            System.out.println("3.Search a book");
            System.out.println("4.List of all books");
            //System.out.println("5.Redo Operation");
            System.out.println("0.To Exit");
            n = scan.nextInt();
            break;

        }
        case 3: {
            System.out.println("Enter book id to search");
            int searchid = scan.nextInt();
            serchfun(searchid);
            // System.out.println("Hey welcome to E-Library");

            System.out.println(" Enter operation you want to perform ");
            System.out.println("1.Insert a book");
            System.out.println("2.Delete a book");
            System.out.println("3.Search a book");
            System.out.println("4.List of all books");
            System.out.println("0.To Exit");
            n = scan.nextInt();
            break;
        }
        case 4: {
            quearyfunction();
            //System.out.println("Hey welcome to E-Library");

            System.out.println(" Enter operation you want to perform ");
            System.out.println("1.Insert a book");
            System.out.println("2.Delete a book");
            System.out.println("3.Search a book");
            System.out.println("4.List of all books");
            System.out.println("0.To Exit");
            n = scan.nextInt();
            break;
        }


          }
      }
    }
}

