package sg.edu.np.mad.mad_prac2;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String name;
    private String description;
    private int id;
    private boolean followed;
    private String uri;


    protected User(Parcel in) {
        name = in.readString();
        description = in.readString();
        id = in.readInt();
        followed = in.readByte() != 0;
        uri = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}
    public void setFollowed(boolean f){this.followed=f;}
    public boolean isFollowed(){return followed;}
    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    public void setUri(String uri){this.uri=uri;}
    public String getUri(){return uri;}


    public User(){

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeInt(id);
        parcel.writeByte((byte) (followed ? 1 : 0));
        parcel.writeString(uri);
    }
}
