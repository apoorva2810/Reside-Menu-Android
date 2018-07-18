package com.apoorvasingh2810.residemenu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class ResideMenuMainActivity extends FragmentActivity implements View.OnClickListener{

    private ResideMenu resideMenu;
    private ResideMenuMainActivity mContext;
    private ResideMenuItem itemHome;
    private ResideMenuItem itemDevelopers;
    private ResideMenuItem itemRegister;
    private ResideMenuItem itemEvents;
    private ResideMenuItem itemMaps;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reside_menu_main);

        mContext = this;
        setUpMenu();
        if( savedInstanceState == null )
            changeFragment(new HomeFragment());
    }

    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(this);
        resideMenu.setUse3D(true);
        resideMenu.setBackground(R.drawable.home_image);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        // resideMenu.setScaleValue(0.6f);

        // create menu items;
        itemHome     = new ResideMenuItem(this, R.mipmap.ic_home_dark,     "Home");
//        itemProfile  = new ResideMenuItem(this, R.drawable.ic_dark_profile,  "Profile");
//        itemCalendar = new ResideMenuItem(this, R.drawable.icon_calendar, "Calendar");
        itemRegister  = new ResideMenuItem(this, R.mipmap.icon_register,  "Register");
//        itemMessage  = new ResideMenuItem(this, R.drawable.ic_dark_message,  "Message");
        itemEvents  = new ResideMenuItem(this, R.mipmap.ic_dark_events,  "Events");
        itemMaps = new ResideMenuItem(this, R.mipmap.icon_settings, "Maps");
        itemDevelopers  = new ResideMenuItem(this, R.mipmap.ic_dark_developers,  "Developers");

        itemHome.setOnClickListener(this);
        itemRegister.setOnClickListener(this);
        itemEvents.setOnClickListener(this);
        itemMaps.setOnClickListener(this);
        itemDevelopers.setOnClickListener(this);

//        itemMessage.setOnClickListener(this);
//        itemEvents.setOnClickListener(this);


        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemRegister, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemEvents, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemMaps, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemDevelopers, ResideMenu.DIRECTION_LEFT);

        // You can disable a direction by setting ->
        // resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
//        findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
//            }
//        });
    }


    /**
     * Dissableing onClick methods for now except for homefragment
     *
     */
    @Override
    public void onClick(View view) {

        if (view == itemHome) {
            changeFragment(new HomeFragment());
//        }else if (view == itemProfile){
//            changeFragment(new ProfileFragment());
//        }else if (view == itemMessage){
//            changeFragment(new MessageFragment());
//        }else if (view == itemFriends){
//            changeFragment(new FriendsFragment());
//        }else if (view == itemEvents){
//            changeFragment(new EventFragment());
//        }else if (view == itemCalendar){
//          //  changeFragment(new CalendarFragment());
//        }else if (view == itemSettings){
//            changeFragment(new SettingsFragment());
//        }
//
//        resideMenu.closeMenu();
        }
    }   // extra } here


    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            //Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            //Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };


    private void changeFragment(Fragment targetFragment){
        resideMenu.clearIgnoredViewList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    // What good method is to access resideMenu？
    public ResideMenu getResideMenu(){
        return resideMenu;
    }


}
