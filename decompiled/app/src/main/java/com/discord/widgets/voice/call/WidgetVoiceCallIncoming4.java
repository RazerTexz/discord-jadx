package com.discord.widgets.voice.call;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.discord.R;
import com.discord.databinding.WidgetVoiceCallIncomingBinding;
import com.discord.widgets.voice.fullscreen.grid.PrivateCallBlurredGridView;
import com.discord.widgets.voice.fullscreen.grid.PrivateCallGridView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetVoiceCallIncoming.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetVoiceCallIncomingBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetVoiceCallIncomingBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceCallIncoming4 extends FunctionReferenceImpl implements Function1<View, WidgetVoiceCallIncomingBinding> {
    public static final WidgetVoiceCallIncoming4 INSTANCE = new WidgetVoiceCallIncoming4();

    public WidgetVoiceCallIncoming4() {
        super(1, WidgetVoiceCallIncomingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetVoiceCallIncomingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetVoiceCallIncomingBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetVoiceCallIncomingBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.incoming_call_accept_alt_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.incoming_call_accept_alt_container);
        if (linearLayout != null) {
            i = R.id.incoming_call_accept_button;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.incoming_call_accept_button);
            if (floatingActionButton != null) {
                i = R.id.incoming_call_accept_video_button;
                FloatingActionButton floatingActionButton2 = (FloatingActionButton) view.findViewById(R.id.incoming_call_accept_video_button);
                if (floatingActionButton2 != null) {
                    i = R.id.incoming_call_blurred_view;
                    PrivateCallBlurredGridView privateCallBlurredGridView = (PrivateCallBlurredGridView) view.findViewById(R.id.incoming_call_blurred_view);
                    if (privateCallBlurredGridView != null) {
                        i = R.id.incoming_call_decline_button;
                        FloatingActionButton floatingActionButton3 = (FloatingActionButton) view.findViewById(R.id.incoming_call_decline_button);
                        if (floatingActionButton3 != null) {
                            i = R.id.incoming_call_status_container;
                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.incoming_call_status_container);
                            if (linearLayout2 != null) {
                                i = R.id.incoming_call_status_primary;
                                TextView textView = (TextView) view.findViewById(R.id.incoming_call_status_primary);
                                if (textView != null) {
                                    i = R.id.incoming_call_status_secondary;
                                    TextView textView2 = (TextView) view.findViewById(R.id.incoming_call_status_secondary);
                                    if (textView2 != null) {
                                        i = R.id.incoming_call_top_guideline;
                                        Guideline guideline = (Guideline) view.findViewById(R.id.incoming_call_top_guideline);
                                        if (guideline != null) {
                                            i = R.id.incoming_call_users_grid_view;
                                            PrivateCallGridView privateCallGridView = (PrivateCallGridView) view.findViewById(R.id.incoming_call_users_grid_view);
                                            if (privateCallGridView != null) {
                                                return new WidgetVoiceCallIncomingBinding((ConstraintLayout) view, linearLayout, floatingActionButton, floatingActionButton2, privateCallBlurredGridView, floatingActionButton3, linearLayout2, textView, textView2, guideline, privateCallGridView);
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
