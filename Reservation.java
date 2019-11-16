
public class Reservation {
    int seats=72;
    int lower[]=new int[18];
    int mid[]=new int[18];
    int upper[]=new int[18];
    int sidelower[]=new int[9];
    int sideupper[]=new int[9];
    int pnr=11003700;
    int pnrseries[]=new int[72];
    int ipr=0;
    int availablity()
    {
        return seats;
    }
    Reservation()
    {

        int u=0,l=0,m=0,sl=0,su=0;
        for(int i=1;i<=72;i++)
        {
            if(i%8==0)
            {
                sideupper[su]=i;
                su++;
            }
            else if((i+1)%8==0)
            {
                sidelower[sl]=i;
                sl++;
            }
            else if((i+2)%8==0||i==3||(i-3)%8==0)
            {
                upper[u]=i;
                u++;
            }
            else if(i==2||(i+3)%8==0||(i-2)%8==0)
            {
                mid[m]=i;
                m++;
            }
            else if(i==1||(i+4)%8==0||(i-1)%8==0)
            {
                lower[l]=i;
                l++;
            }
        }

    }
    void booknew(String name,String ch)
    {
        String p="";
        if(seats==0)
        {
            System.out.println("SORRY Tickets are full");
        }
        else {
            int bookedseat = 0, flag = 0;
            int pnrno=0;
            if (ch.equals("L")) {
                for (int i = 0; i < 18; i++) {
                    if (lower[i] <= 72) {
                        bookedseat = lower[i];
                        lower[i] = bookedseat + pnr;
                        pnrseries[ipr]=lower[i];
                        ipr++;
                        pnrno=lower[i];
                        seats--;
                        flag = -1;
                        p = "L";
                        break;
                    }
                }
            } else if (ch.equals("U")) {
                for (int i = 0; i < 18; i++) {
                    if (upper[i] < 73) {
                        bookedseat = upper[i];
                        upper[i] = bookedseat + pnr;
                        pnrno=upper[i];
                        pnrseries[ipr]=upper[i];
                        ipr++;
                        seats--;
                        flag = -1;
                        p = "U";
                        break;
                    }
                }
            } else if (ch.equals("M")) {
                for (int i = 0; i < 18; i++) {
                    if (mid[i] < 73) {
                        bookedseat = mid[i];
                        mid[i] = bookedseat + pnr;
                        pnrno=mid[i];
                        seats--;
                        pnrseries[ipr]=mid[i];
                        ipr++;
                        flag = -1;
                        p = "M";
                        break;
                    }
                }
            } else if (ch.equals("SL")) {

                for (int i = 0; i < 9; i++) {
                    if (sidelower[i] < 73) {
                        bookedseat = sidelower[i];
                        sidelower[i] = bookedseat + pnr;
                        pnrno = sidelower[i];
                        flag=-1;
                        pnrseries[ipr]=sidelower[i];
                        ipr++;
                        seats--;
                        p="SL";
                        break;
                }
            }} else if (ch.equals("SU")) {
                for (int i = 0; i < 9; i++) {
                    if (sideupper[i] < 73) {
                        bookedseat = sideupper[i];
                        sideupper[i] = bookedseat + pnr;
                        seats--;
                        pnrno=sideupper[i];
                        pnrseries[ipr]=sideupper[i];
                        ipr++;
                        flag = -1;
                        p = "SU";
                        break;
                    }
                }
            }
            if (flag == -1) {
                System.out.println("Booking succesfull");
                System.out.println("Name: " + name);
                System.out.println("Pnr No: " + pnrno);
                System.out.println("Seat no: " + bookedseat + " BERTH : " + p);
            }
            else if (ch.equals("L")) {
                booknew(name, "M");
            }
            else if ( ch.equals("M")) {
                booknew(name, "U");
            }
            else if (ch.equals("SL")) {
                booknew(name, "SU");
            }
        }
    }

    void cancellation(int pnrNo)
    {
        int flag=-1;
        for(int i=0;i<72;i++)
        {
            if(pnrseries[i]==pnrNo) {
                pnrseries[i]=0;
                flag = 0;
            }
        }
        if(flag==-1)
        {
            System.out.println("pnr no not found");
        }
        else{
        int rseat=pnrNo-11003700;

        if(rseat%8==0)
        {
            for(int i=0;i<9;i++)
            {
                if(sideupper[i]==pnrNo){
                    sideupper[i]=rseat;
                    seats++;
                    break;
                }
            }
        }
        else if((rseat+1)%8==0)
        {
            for(int i=0;i<9;i++)
            {
                if(sidelower[i]==pnrNo){
                    sidelower[i]=rseat;
                    seats++;
                    break;
                }
            }
        }
        else if((rseat+2)%8==0||rseat==3||(rseat-3)%8==0)
        {
            for(int i=0;i<18;i++)
            {
                if(sidelower[i]==pnrNo){
                    sidelower[i]=rseat;
                    seats++;
                    break;
                }
            }
        }
        else if(rseat==2||(rseat+3)%8==0||(rseat-2)%8==0)
        {
            for(int i=0;i<18;i++)
            {
                if(upper[i]==pnrNo){
                    upper[i]=rseat;
                    seats++;
                    break;
                }
            }
        }
        else if(rseat==2||(rseat+3)%8==0||(rseat-2)%8==0)
        {
            for(int i=0;i<18;i++)
            {
                if(mid[i]==pnrNo){
                    mid[i]=rseat;
                    seats++;
                    break;
                }
            }
        }
        else if(rseat==1||(rseat+4)%8==0||(rseat-1)%8==0)
        {
            for(int i=0;i<18;i++)
            {
                if(lower[i]==pnrNo){
                    lower[i]=rseat;
                    seats++;
                    break;
                }
            }
        }
        System.out.println("your ticket pnr No."+pnrNo+" is successfully cancelled");
    }
    }
}
