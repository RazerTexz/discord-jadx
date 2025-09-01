package com.discord.widgets.stage.sheet;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Group;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetStageRaisedHandsBottomSheetBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetStageRaisedHandsBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetStageRaisedHandsBottomSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetStageRaisedHandsBottomSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageRaisedHandsBottomSheet4 extends FunctionReferenceImpl implements Function1<View, WidgetStageRaisedHandsBottomSheetBinding> {
    public static final WidgetStageRaisedHandsBottomSheet4 INSTANCE = new WidgetStageRaisedHandsBottomSheet4();

    public WidgetStageRaisedHandsBottomSheet4() {
        super(1, WidgetStageRaisedHandsBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageRaisedHandsBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStageRaisedHandsBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStageRaisedHandsBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.header;
        View viewFindViewById = view.findViewById(R.id.header);
        if (viewFindViewById != null) {
            i = R.id.raised_hands_count_label;
            MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R.id.raised_hands_count_label);
            if (materialTextView != null) {
                i = R.id.raised_hands_empty_group;
                Group group = (Group) view.findViewById(R.id.raised_hands_empty_group);
                if (group != null) {
                    i = R.id.raised_hands_empty_sparkle;
                    ImageView imageView = (ImageView) view.findViewById(R.id.raised_hands_empty_sparkle);
                    if (imageView != null) {
                        i = R.id.raised_hands_empty_subtitle;
                        MaterialTextView materialTextView2 = (MaterialTextView) view.findViewById(R.id.raised_hands_empty_subtitle);
                        if (materialTextView2 != null) {
                            i = R.id.raised_hands_empty_title;
                            MaterialTextView materialTextView3 = (MaterialTextView) view.findViewById(R.id.raised_hands_empty_title);
                            if (materialTextView3 != null) {
                                i = R.id.stage_raise_hands_enabled_toggle;
                                SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(R.id.stage_raise_hands_enabled_toggle);
                                if (switchMaterial != null) {
                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                                    i = R.id.stage_raised_hands_recycler;
                                    MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view.findViewById(R.id.stage_raised_hands_recycler);
                                    if (maxHeightRecyclerView != null) {
                                        i = R.id.subtitle;
                                        MaterialTextView materialTextView4 = (MaterialTextView) view.findViewById(R.id.subtitle);
                                        if (materialTextView4 != null) {
                                            i = R.id.title;
                                            MaterialTextView materialTextView5 = (MaterialTextView) view.findViewById(R.id.title);
                                            if (materialTextView5 != null) {
                                                i = R.id.toggle_speaker_state_button;
                                                MaterialTextView materialTextView6 = (MaterialTextView) view.findViewById(R.id.toggle_speaker_state_button);
                                                if (materialTextView6 != null) {
                                                    i = R.id.toggle_speaker_state_group;
                                                    Group group2 = (Group) view.findViewById(R.id.toggle_speaker_state_group);
                                                    if (group2 != null) {
                                                        i = R.id.toggle_speaker_state_icon;
                                                        ImageView imageView2 = (ImageView) view.findViewById(R.id.toggle_speaker_state_icon);
                                                        if (imageView2 != null) {
                                                            return new WidgetStageRaisedHandsBottomSheetBinding(coordinatorLayout, viewFindViewById, materialTextView, group, imageView, materialTextView2, materialTextView3, switchMaterial, coordinatorLayout, maxHeightRecyclerView, materialTextView4, materialTextView5, materialTextView6, group2, imageView2);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
