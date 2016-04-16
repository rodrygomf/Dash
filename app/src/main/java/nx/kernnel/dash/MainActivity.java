package nx.kernnel.dash;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import nx.kernnel.dash.Adapter.LocalAdapter;
import nx.kernnel.dash.Entity.DashLocation;
import nx.kernnel.dash.Entity.Local;
import nx.kernnel.dash.Entity.Usuario;

public class MainActivity extends AppCompatActivity {
    private static Usuario usuario;


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private RecyclerView rvLocal;

        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View localView = inflater.inflate(R.layout.fragment_main, container, false);

            switch(getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1: { // Places
                    setUI(localView);
                    setRecyvlerView(localView);

                    return localView;
                }case 2: { // Profile
                    View profileView = inflater.inflate(R.layout.fragment_profile, container, false);

                    TextView tvUsername = (TextView) profileView.findViewById(R.id.username_label);
                    tvUsername.setText( usuario.getNome() != null ? usuario.getNome() : "NULO" );

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    TextView tvDatanasc = (TextView) profileView.findViewById(R.id.datanasc_user_label);
                    tvDatanasc.setText( usuario.getDataNasc() != null ? simpleDateFormat.format(usuario.getDataNasc()) : "NULO" );

                    TextView tvSexo = (TextView) profileView.findViewById(R.id.sexo_user_label);
                    tvSexo.setText( usuario.getSexo() != null ? usuario.getSexo() == true ? "Masculino" : "Feminino" : "NULO" );

                    TextView tvEmail = (TextView) profileView.findViewById(R.id.email_user_label);
                    tvEmail.setText(usuario.getLogin() != null ? usuario.getLogin() : "NULO");

                    ImageButton ibLocation = (ImageButton) profileView.findViewById(R.id.dash_location);
                    ibLocation.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                             goToMap(usuario.getDashLocation());
                         }
                    });

                    return profileView;
                }default: {
                    return localView;
                }
            }
        }

        private void setUI(View view) {
            rvLocal = (RecyclerView) view.findViewById(R.id.rv_local);
        }

        private void setRecyvlerView(View view) {
            rvLocal.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
            rvLocal.setLayoutManager(layoutManager);

            final Local local = new Local();

            LocalAdapter localAdapter = new LocalAdapter(local.getLista());
            localAdapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    goToMap(local.getLista().get(rvLocal.getChildLayoutPosition(view)).getDashLocation());
                }
            });

            rvLocal.setAdapter(localAdapter);
            rvLocal.setItemAnimator(new DefaultItemAnimator());
        }

        private void goToMap(DashLocation dashLocation) {
            Intent intent = new Intent(this.getContext(), MapsActivity.class);
            intent.putExtra("dashLocation", dashLocation);
            startActivity(intent);
        }

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.local);
                case 1:
                    return getString(R.string.profile);
            }
            return null;
        }
    }
}
