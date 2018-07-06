package novosardian.david;


public class killedPerson
{
    private String id;
    private String name;
    private String date;
    private String manner_of_death;
    private String armed;
    private String gender;
    private String race;
    private String city;
    private String state;
    private String signs_of_mental_illness;
    private String threat_level;
    private String flee;
    private String body_camera;
    private String age;

    public killedPerson()
    {

    }

    public killedPerson(String line) throws Exception
    {
        //String[] fields = line.split(",");
        String[] fields = line.split(",");
        if (fields.length !=14)
        {
            throw new Exception("Invalid number of fields");
        }

        id =  fields[0];
        name =  fields[1];
        date =  fields[2];
        manner_of_death =  fields[3];
        armed =  fields[4];
        age = fields[5];
        gender =  fields[6];
        race =  fields[7];
        city =  fields[8];
        state =  fields[9];
        signs_of_mental_illness =  fields[10];
        threat_level =  fields[11];
        flee =  fields[12];
        body_camera =  fields[13];
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getManner_of_death()
    {
        return manner_of_death;
    }

    public void setManner_of_death(String manner_of_death)
    {
        this.manner_of_death = manner_of_death;
    }

    public String getArmed()
    {
        return armed;
    }

    public void setArmed(String armed)
    {
        this.armed = armed;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getRace()
    {
        return race;
    }

    public void setRace(String race)
    {
        this.race = race;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getSigns_of_mental_illness()
    {
        return signs_of_mental_illness;
    }

    public void setSigns_of_mental_illness(String signs_of_mental_illness)
    {
        this.signs_of_mental_illness = signs_of_mental_illness;
    }

    public String getThreat_level()
    {
        return threat_level;
    }

    public void setThreat_level(String threat_level)
    {
        this.threat_level = threat_level;
    }

    public String getFlee()
    {
        return flee;
    }

    public void setFlee(String flee)
    {
        this.flee = flee;
    }

    public String getBody_camera()
    {
        return body_camera;
    }

    public void setBody_camera(String body_camera)
    {
        this.body_camera = body_camera;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }
}
