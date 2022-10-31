package com.example.safeshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductSpecificationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductSpecificationFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProductSpecificationFragment() {
        // Required empty public constructor
    }

    private RecyclerView productSpecificationRecyclerview;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductSpecificationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductSpecificationFragment newInstance(String param1, String param2) {
        ProductSpecificationFragment fragment = new ProductSpecificationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_product_specification, container, false);
        productSpecificationRecyclerview=view.findViewById(R.id.product_specification_recycler_view);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        productSpecificationRecyclerview.setLayoutManager(linearLayoutManager);
        List<ProductSpecificationModel> productSpecificationModelList=new ArrayList<>();
        productSpecificationModelList.add(new ProductSpecificationModel(0,"SIZES"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Size","32"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Size","34"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Size","36"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Size","38"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Size","40"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Size","42"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"COLOURS"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Colour","Black"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Colour","White"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Colour","Red"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Colour","Green"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Colour","Orange"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"TYPES"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Type","Cotton"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Type","Rayon"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Type","Silk"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Type","Muslin"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"BRANDS"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Brand","Allen Solly"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Brand","Puma"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Brand","Levis"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Brand","US Polo"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Brand","Louis Philippe"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Brand","Peter England"));


        ProductSpecificationAdapter productSpecificationAdapter=new ProductSpecificationAdapter(productSpecificationModelList);
        productSpecificationRecyclerview.setAdapter(productSpecificationAdapter);
        productSpecificationAdapter.notifyDataSetChanged();
        return view;
    }
}