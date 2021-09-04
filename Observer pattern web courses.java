import java.util.List ;
    import java.util.ArrayList ;
    class Course {
          private String dept_code ;
          private String crse_number ;
          private String crse_title ;
          // in reality we would have crse_description, but I don't want to bother
    with it.
          private int credits ;
          // default constructor
          // assign default values to instance variables
          public Course()
          {
                set_dept_code( "" ) ;
                set_crse_number( "" ) ;
{ 
} 
return 
"\nDepartment  : " + dept_code    +
"\nCourse #    : " + crse_number  +
"\nCourse title: " + crse_title +
"\nCredits     : " + credits + "\n" ;
set_crse_title( "" ) ;
            set_credits ( 0 ) ;
      }
      public Course( String dept_code, String crse_number, String crse_title,
int crse_credits )
      {
            set_dept_code( dept_code ) ;
            set_crse_number( crse_number ) ;
            set_crse_title( crse_title ) ;
            set_credits ( crse_credits ) ;
      }
      public void set_dept_code( String dept_code )
      {
            this.dept_code = dept_code ;
} 
      public String get_dept_code( )
      {
            return this.dept_code ;
      }
      public void set_crse_number( String crse_number )
      {
            this.crse_number = crse_number ;
} 
      public void set_crse_title( String crse_title )
      {
            this.crse_title = crse_title ;
      }
      public String get_crse_title( )
      {
            return this.crse_title ;
} 
      public String get_crse_number( )
      {
            return this.crse_number ;
      }
      public void set_credits ( int credits )
      {
            this.credits = credits ;
} 
      public int get_credits ( )
      {
            return this.credits ;
      }
      public String toString()
} 
interface Observer
{
      final int ADD_INDICATOR= 1 ; // indicates that a course is being added to
the catalog
      final int REM_INDICATOR= -1 ; // indicates that a course is being removed
the catalog
      public void update( int addOrRemove, Course courseObj ) ;
}
interface Subject
{
      final int ADD_INDICATOR= 1 ; // indicates that a course is being added to
the catalog 
      final int REM_INDICATOR= -1 ; // indicates that a course is being removed
the catalog
      public void registerObserver( Observer observerObj ) ;
      public void removeObserver( Observer observerObj ) ;
public void notifyObservers( int addOrRemove, Course courseObj) ; // 
addOrRemove indicates
perform } 
interface DisplayCourses
// the action to
    {
          public void display( int addOrRemove, Course courseObj ) ;
} 
    class MasterCourseCatalog implements Subject
    {
          public List < Observer > observerList  = new ArrayList <> () ; ; // the
    list of observers
public List < Course > courseList = new ArrayList <> () ; ; // the list of courses in the catalog 
          MasterCourseCatalog()
          {
List < Observer > _observerList; 
List < Course > _courseList ; 
           _observerList = observerList;
           _courseList =courseList;
} 
          public void registerObserver( Observer observerObj )
          {
                observerList.add( observerObj ) ;
                // System.out.println("\n registered observer ") ;
          }
          public void removeObserver( Observer observerObj )
{
      // need to do something here.
      observerList.remove(observerObj);
}
public void notifyObservers( int addOrRemove, Course courseObj)
{
      for ( Observer o : observerList )
      {
            o.update( addOrRemove, courseObj );
courseObj ) ;
            }
} 
//System.out.println("\n notified observer of " +
          public void addCourse( Course newCourse)
          {
                courseList.add( newCourse ) ;
                // need to do something here.
          }
          public void removeCourse( Course courseToRemove)
          {
                // need to do something here.
                courseList.remove(courseToRemove) ;
                notifyObservers( REM_INDICATOR, courseToRemove) ;
} } 
    class  WebCourseCatalog implements Observer, DisplayCourses
    {
          private List<Course> courseList ;
          private List<Observer> observerList;
          private Course courseObj;
          private Observer observerObj;
          private MasterCourseCatalog webMasterCourseCatalogueobj;
          public WebCourseCatalog( List<Course> courseList1, List<Observer>
    observerList1) {
          for(int i = 0 ; i < courseList1.size(); i++) {
                webMasterCourseCatalogueobj.courseList.add(courseList1.get(i)) ;
} 
          for(int k = 0 ; k < observerList1.size(); k++) {
                webMasterCourseCatalogueobj.observerList.add(observerList1.get(k));
} 
          }
      public void update(int addOrRemove, Course courseObj) {
            if(addOrRemove == ADD_INDICATOR) {
                webMasterCourseCatalogueobj.courseList.add(courseObj) ;
} 
} } 
      public void display( int addOrRemove, Course courseObj )
      {
            String message ;
            if ( addOrRemove == ADD_INDICATOR ) message = "Course " +
    courseObj.get_crse_number() + " was added" ;
            else message = "Course " + courseObj.get_crse_number() + " was
    removed" ;
            System.out.println( "\n\n **** Web class catalog " + message ) ;
            System.out.println( "\n\n ************ Web classs Course List
    *************\n" ) ;
} } 
    class BackupCourseCatalog implements Observer, DisplayCourses
    {
          private List < Course > courseList = new ArrayList< > () ;
          public BackupCourseCatalog ( )
          {
                // needed this because we have the following constructor which I
    probably should have deleted.
          }
          public BackupCourseCatalog ( List < Course > courseList ) // the
    constructor populates the courseList.
          {
                // got bored and didn't use this.
                for ( int i = 0 ; i < courseList.size() ; i ++ )
                {
                      this.courseList.add ( courseList.get( i ) ) ;
                }
} 
          public void update( int addOrRemove, Course courseObj )
          {
                if ( addOrRemove == ADD_INDICATOR )
                {
                      // need to do something here.
                      courseList.add(courseObj) ;
} 
else { 
else{
    webMasterCourseCatalogueobj.courseList.remove(courseObj);
// need to do something here.
courseList.remove(courseObj);
} 
            display( addOrRemove, courseObj ) ;
      }
      public void display( int addOrRemove, Course courseObj )
      {
            String message ;
            if ( addOrRemove == ADD_INDICATOR ) message = "Course " +
courseObj.get_crse_number() + " was added" ;
removed" ; 
else message = "Course " + courseObj.get_crse_number() + " was
System.out.println( "\n\n **** Webclass catalog " + message ) ;
            System.out.println( "\n\n ************ Webclass  Course List
*************\n" ) ;
            for ( Course c : courseList )
            {
                  System.out.println( c ) ;
} } 
}
