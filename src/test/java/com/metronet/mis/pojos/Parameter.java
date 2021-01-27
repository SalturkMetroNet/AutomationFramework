package com.metronet.mis.pojos;

import java.util.List;

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


    public String getTv()
    {
        return tv;
    }

    public void setTv(String tv)
    {
        this.tv = tv;
    }

    public String getIptv()
    {
        return iptv;
    }

    public void setIptv(String iptv)
    {
        this.iptv = iptv;
    }

    public String getDvr()
    {
        return dvr;
    }

    public void setDvr(String dvr)
    {
        this.dvr = dvr;
    }

    public String getDvr_pc()
    {
        return dvr_pc;
    }

    public void setDvr_pc(String dvr_pc)
    {
        this.dvr_pc = dvr_pc;
    }

    public String getDvr_rc()
    {
        return dvr_rc;
    }

    public void setDvr_rc(String dvr_rc)
    {
        this.dvr_rc = dvr_rc;
    }

    public String getDvr_return()
    {
        return dvr_return;
    }

    public void setDvr_return(String dvr_return)
    {
        this.dvr_return = dvr_return;
    }

    public String getStb()
    {
        return stb;
    }

    public void setStb(String stb)
    {
        this.stb = stb;
    }

    public String getStb_pc()
    {
        return stb_pc;
    }

    public void setStb_pc(String stb_pc)
    {
        this.stb_pc = stb_pc;
    }

    public String getStb_rc()
    {
        return stb_rc;
    }

    public void setStb_rc(String stb_rc)
    {
        this.stb_rc = stb_rc;
    }

    public String getStb_return()
    {
        return stb_return;
    }

    public void setStb_return(String stb_return)
    {
        this.stb_return = stb_return;
    }

    public String getHdelite()
    {
        return hdelite;
    }

    public void setHdelite(String hdelite)
    {
        this.hdelite = hdelite;
    }

    public String getSportstier()
    {
        return sportstier;
    }

    public void setSportstier(String sportstier)
    {
        this.sportstier = sportstier;
    }

    public String getStarz()
    {
        return starz;
    }

    public void setStarz(String starz)
    {
        this.starz = starz;
    }

    public String getCinemax()
    {
        return cinemax;
    }

    public void setCinemax(String cinemax)
    {
        this.cinemax = cinemax;
    }

    public String getShowtime()
    {
        return showtime;
    }

    public void setShowtime(String showtime)
    {
        this.showtime = showtime;
    }

    public String getHbo()
    {
        return hbo;
    }

    public void setHbo(String hbo)
    {
        this.hbo = hbo;
    }

    public String getSpeed()
    {
        return speed;
    }

    public void setSpeed(String speed)
    {
        this.speed = speed;
    }

    public String getRouter()
    {
        return router;
    }

    public void setRouter(String router)
    {
        this.router = router;
    }

    public String getProuter()
    {
        return prouter;
    }

    public void setProuter(String prouter)
    {
        this.prouter = prouter;
    }

    public String getUrouter()
    {
        return urouter;
    }

    public void setUrouter(String urouter)
    {
        this.urouter = urouter;
    }

    public String getSipaddress()
    {
        return sipaddress;
    }

    public void setSipaddress(String sipaddress)
    {
        this.sipaddress = sipaddress;
    }

    public String getThp()
    {
        return thp;
    }

    public void setThp(String thp)
    {
        this.thp = thp;
    }

    public String getThp_mob()
    {
        return thp_mob;
    }

    public void setThp_mob(String thp_mob)
    {
        this.thp_mob = thp_mob;
    }

    public String getThp_desk()
    {
        return thp_desk;
    }

    public void setThp_desk(String thp_desk)
    {
        this.thp_desk = thp_desk;
    }

    public String getThs()
    {
        return ths;
    }

    public void setThs(String ths)
    {
        this.ths = ths;
    }

    public String getThs_mob()
    {
        return ths_mob;
    }

    public void setThs_mob(String ths_mob)
    {
        this.ths_mob = ths_mob;
    }

    public String getThs_desk()
    {
        return ths_desk;
    }

    public void setThs_desk(String ths_desk)
    {
        this.ths_desk = ths_desk;
    }

    public String getWholeHome()
    {
        return wholeHome;
    }

    public void setWholeHome(String wholeHome)
    {
        this.wholeHome = wholeHome;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getFiberPhone()
    {
        return fiberPhone;
    }

    public void setFiberPhone(String fiberPhone)
    {
        this.fiberPhone = fiberPhone;
    }

    public String getBatteryBackup()
    {
        return batteryBackup;
    }

    public void setBatteryBackup(String batteryBackup)
    {
        this.batteryBackup = batteryBackup;
    }

    @Override
    public String toString()
    {
        return "Parameter{" +
                "tv='" + tv + '\'' +
                ", iptv='" + iptv + '\'' +
                ", dvr='" + dvr + '\'' +
                ", dvr_pc='" + dvr_pc + '\'' +
                ", dvr_rc='" + dvr_rc + '\'' +
                ", dvr_return='" + dvr_return + '\'' +
                ", stb='" + stb + '\'' +
                ", stb_pc='" + stb_pc + '\'' +
                ", stb_rc='" + stb_rc + '\'' +
                ", stb_return='" + stb_return + '\'' +
                ", hdelite='" + hdelite + '\'' +
                ", sportstier='" + sportstier + '\'' +
                ", starz='" + starz + '\'' +
                ", cinemax='" + cinemax + '\'' +
                ", showtime='" + showtime + '\'' +
                ", hbo='" + hbo + '\'' +
                ", speed='" + speed + '\'' +
                ", router='" + router + '\'' +
                ", prouter='" + prouter + '\'' +
                ", urouter='" + urouter + '\'' +
                ", sipaddress='" + sipaddress + '\'' +
                ", thp='" + thp + '\'' +
                ", thp_mob='" + thp_mob + '\'' +
                ", thp_desk='" + thp_desk + '\'' +
                ", ths='" + ths + '\'' +
                ", ths_mob='" + ths_mob + '\'' +
                ", ths_desk='" + ths_desk + '\'' +
                ", wholeHome='" + wholeHome + '\'' +
                ", phone='" + phone + '\'' +
                ", fiberPhone='" + fiberPhone + '\'' +
                ", batteryBackup='" + batteryBackup + '\'' +
                '}';
    }


}
