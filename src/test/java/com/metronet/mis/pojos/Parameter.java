package com.metronet.mis.pojos;

import java.util.List;
import java.util.Map;

/**
 * Parameter class to contain parameters
 */
public class Parameter
{
    String tv;
    String iptv;
    String dvr;
    String dvr_pc;
    String dvr_rc;
    String dvr_return;
    String stb;
    String stb_pc;
    String stb_rc;
    String stb_return;
    String hdelite;
    String sportstier;
    String starz;
    String cinemax;
    String showtime;
    String hbo;
    String speed;
    String router;
    String prouter;
    String urouter;
    String sipaddress;
    String thp;
    String thp_mob;
    String thp_desk;
    String ths;
    String ths_mob;
    String ths_desk;
    String wholeHome;
    String phone;
    String fiberPhone;
    String batteryBackup;

    public Parameter(List<String> parameters)
    {
        this.tv = parameters.get(0);
        this.iptv = parameters.get(1);
        this.dvr = parameters.get(2);
        this.dvr_pc = parameters.get(3);
        this.dvr_rc = parameters.get(4);
        this.dvr_return = parameters.get(5);
        this.stb = parameters.get(6);
        this.stb_pc = parameters.get(7);
        this.stb_rc = parameters.get(8);
        this.stb_return = parameters.get(9);
        this.hdelite = parameters.get(10);
        this.sportstier = parameters.get(11);
        this.starz = parameters.get(12);
        this.cinemax = parameters.get(13);
        this.showtime = parameters.get(14);
        this.hbo = parameters.get(15);
        this.speed = parameters.get(16);
        this.router = parameters.get(17);
        this.prouter = parameters.get(18);
        this.urouter = parameters.get(19);
        this.sipaddress = parameters.get(20);
        this.thp = parameters.get(21);
        this.thp_mob = parameters.get(22);
        this.thp_desk = parameters.get(23);
        this.ths = parameters.get(24);
        this.ths_mob = parameters.get(25);
        this.ths_desk = parameters.get(26);
        this.wholeHome = parameters.get(27);
        this.phone = parameters.get(28);
        this.batteryBackup = parameters.get(29);
    }

    public Parameter(Map<String, String> parameters)
    {
        this.tv = parameters.get("TV");
        this.iptv = parameters.get("IPTV");
        this.dvr = parameters.get("DVR");
        this.dvr_pc = parameters.get("Replacement Power Cord");
        this.dvr_rc = parameters.get("Replacement Remote Control DVR");
        this.dvr_return = parameters.get("Unreturned DVR");
        this.stb = parameters.get("STB");
        this.stb_pc = parameters.get("Replacement Power Cord STB");
        this.stb_rc = parameters.get("Replacement Remote Control STB");
        this.stb_return = parameters.get("Unreturned STB");
        this.hdelite = parameters.get("HDElite");
        this.sportstier = parameters.get("Sports Tier");
        this.starz = parameters.get("Starz");
        this.cinemax = parameters.get("Cinemax");
        this.showtime = parameters.get("Showtime");
        this.hbo = parameters.get("HBO");
        this.speed = parameters.get("Speed");
        this.router = parameters.get("Router");
        this.prouter = parameters.get("Purchased Router");
        this.urouter = parameters.get("Unreturned Router");
        this.sipaddress = parameters.get("Static IP Address");
        this.thp = parameters.get("Tech Home Protect");
        this.thp_mob = parameters.get("Mobile Protect Add-On THP");
        this.thp_desk = parameters.get("Desktop Protect Add-On THP");
        this.ths = parameters.get("Tech Home Support");
        this.ths_mob = parameters.get("Mobile Protect Add-On THS");
        this.ths_desk = parameters.get("Desktop Protect Add-On THS");
        this.wholeHome = parameters.get("Add WholeHomeWifi");
        this.phone = parameters.get("Phone");
        this.batteryBackup = parameters.get("Battery Backup");
    }

    public String getTv()
    {
        return this.tv;
    }

    public void setTv(String tv)
    {
        this.tv = tv;
    }

    public String getIptv()
    {
        return this.iptv;
    }

    public void setIptv(String iptv)
    {
        this.iptv = iptv;
    }

    public String getDvr()
    {
        return this.dvr;
    }

    public void setDvr(String dvr)
    {
        this.dvr = dvr;
    }

    public String getDvr_pc()
    {
        return this.dvr_pc;
    }

    public void setDvr_pc(String dvr_pc)
    {
        this.dvr_pc = dvr_pc;
    }

    public String getDvr_rc()
    {
        return this.dvr_rc;
    }

    public void setDvr_rc(String dvr_rc)
    {
        this.dvr_rc = dvr_rc;
    }

    public String getDvr_return()
    {
        return this.dvr_return;
    }

    public void setDvr_return(String dvr_return)
    {
        this.dvr_return = dvr_return;
    }

    public String getStb()
    {
        return this.stb;
    }

    public void setStb(String stb)
    {
        this.stb = stb;
    }

    public String getStb_pc()
    {
        return this.stb_pc;
    }

    public void setStb_pc(String stb_pc)
    {
        this.stb_pc = stb_pc;
    }

    public String getStb_rc()
    {
        return this.stb_rc;
    }

    public void setStb_rc(String stb_rc)
    {
        this.stb_rc = stb_rc;
    }

    public String getStb_return()
    {
        return this.stb_return;
    }

    public void setStb_return(String stb_return)
    {
        this.stb_return = stb_return;
    }

    public String getHdelite()
    {
        return this.hdelite;
    }

    public void setHdelite(String hdelite)
    {
        this.hdelite = hdelite;
    }

    public String getSportstier()
    {
        return this.sportstier;
    }

    public void setSportstier(String sportstier)
    {
        this.sportstier = sportstier;
    }

    public String getStarz()
    {
        return this.starz;
    }

    public void setStarz(String starz)
    {
        this.starz = starz;
    }

    public String getCinemax()
    {
        return this.cinemax;
    }

    public void setCinemax(String cinemax)
    {
        this.cinemax = cinemax;
    }

    public String getShowtime()
    {
        return this.showtime;
    }

    public void setShowtime(String showtime)
    {
        this.showtime = showtime;
    }

    public String getHbo()
    {
        return this.hbo;
    }

    public void setHbo(String hbo)
    {
        this.hbo = hbo;
    }

    public String getSpeed()
    {
        return this.speed;
    }

    public void setSpeed(String speed)
    {
        this.speed = speed;
    }

    public String getRouter()
    {
        return this.router;
    }

    public void setRouter(String router)
    {
        this.router = router;
    }

    public String getProuter()
    {
        return this.prouter;
    }

    public void setProuter(String prouter)
    {
        this.prouter = prouter;
    }

    public String getUrouter()
    {
        return this.urouter;
    }

    public void setUrouter(String urouter)
    {
        this.urouter = urouter;
    }

    public String getSipaddress()
    {
        return this.sipaddress;
    }

    public void setSipaddress(String sipaddress)
    {
        this.sipaddress = sipaddress;
    }

    public String getThp()
    {
        return this.thp;
    }

    public void setThp(String thp)
    {
        this.thp = thp;
    }

    public String getThp_mob()
    {
        return this.thp_mob;
    }

    public void setThp_mob(String thp_mob)
    {
        this.thp_mob = thp_mob;
    }

    public String getThp_desk()
    {
        return this.thp_desk;
    }

    public void setThp_desk(String thp_desk)
    {
        this.thp_desk = thp_desk;
    }

    public String getThs()
    {
        return this.ths;
    }

    public void setThs(String ths)
    {
        this.ths = ths;
    }

    public String getThs_mob()
    {
        return this.ths_mob;
    }

    public void setThs_mob(String ths_mob)
    {
        this.ths_mob = ths_mob;
    }

    public String getThs_desk()
    {
        return this.ths_desk;
    }

    public void setThs_desk(String ths_desk)
    {
        this.ths_desk = ths_desk;
    }

    public String getWholeHome()
    {
        return this.wholeHome;
    }

    public void setWholeHome(String wholeHome)
    {
        this.wholeHome = wholeHome;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getFiberPhone()
    {
        return this.fiberPhone;
    }

    public void setFiberPhone(String fiberPhone)
    {
        this.fiberPhone = fiberPhone;
    }

    public String getBatteryBackup()
    {
        return this.batteryBackup;
    }

    public void setBatteryBackup(String batteryBackup)
    {
        this.batteryBackup = batteryBackup;
    }

    @Override
    public String toString()
    {
        return "Parameters {" +
                "tv='" + getTv() + '\'' +
                ", iptv='" + getIptv() + '\'' +
                ", dvr='" + getDvr() + '\'' +
                ", dvr_pc='" + getDvr_pc() + '\'' +
                ", dvr_rc='" + getDvr_rc() + '\'' +
                ", dvr_return='" + getDvr_return() + '\'' +
                ", stb='" + getStb() + '\'' +
                ", stb_pc='" + getStb_pc() + '\'' +
                ", stb_rc='" + getStb_rc() + '\'' +
                ", stb_return='" + getStb_return() + '\'' +
                ", hdelite='" + getHdelite() + '\'' +
                ", sportstier='" + getSportstier() + '\'' +
                ", starz='" + getStarz() + '\'' +
                ", cinemax='" + getCinemax() + '\'' +
                ", showtime='" + getShowtime() + '\'' +
                ", hbo='" + getHbo() + '\'' +
                ", speed='" + getSpeed() + '\'' +
                ", router='" + getRouter() + '\'' +
                ", prouter='" + getProuter() + '\'' +
                ", urouter='" + getUrouter() + '\'' +
                ", sipaddress='" + getSipaddress() + '\'' +
                ", thp='" + getThp() + '\'' +
                ", thp_mob='" + getThp_mob() + '\'' +
                ", thp_desk='" + getThp_desk() + '\'' +
                ", ths='" + getThs() + '\'' +
                ", ths_mob='" + getThs_mob() + '\'' +
                ", ths_desk='" + getThs_desk() + '\'' +
                ", wholeHome='" + getWholeHome() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", fiberPhone='" + getFiberPhone() + '\'' +
                ", batteryBackup='" + getBatteryBackup() + '\'' +
                '}';
    }


}
