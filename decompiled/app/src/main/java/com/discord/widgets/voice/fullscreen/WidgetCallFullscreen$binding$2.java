package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.WidgetCallFullscreenAudioShareWarningBinding;
import b.a.i.WidgetCallFullscreenPrivateCallBinding;
import com.discord.R;
import com.discord.databinding.WidgetCallFullscreenBinding;
import com.discord.views.calls.CallEventsButtonView;
import com.discord.views.calls.StageCallVisitCommunityView;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.views.calls.VoiceCallActiveEventView;
import com.discord.views.user.UserSummaryView;
import com.discord.widgets.voice.controls.VoiceControlsSheetView;
import com.discord.widgets.voice.fullscreen.grid.PrivateCallBlurredGridView;
import com.discord.widgets.voice.fullscreen.grid.PrivateCallGridView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetCallFullscreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetCallFullscreenBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetCallFullscreenBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFullscreen$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetCallFullscreenBinding> {
    public static final WidgetCallFullscreen$binding$2 INSTANCE = new WidgetCallFullscreen$binding$2();

    public WidgetCallFullscreen$binding$2() {
        super(1, WidgetCallFullscreenBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCallFullscreenBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetCallFullscreenBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetCallFullscreenBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_toolbar;
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.action_bar_toolbar);
        if (toolbar != null) {
            i = R.id.action_bar_toolbar_layout;
            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.action_bar_toolbar_layout);
            if (appBarLayout != null) {
                i = R.id.action_bar_underlay;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.action_bar_underlay);
                if (relativeLayout != null) {
                    i = R.id.audio_share;
                    View viewFindViewById = view.findViewById(R.id.audio_share);
                    if (viewFindViewById != null) {
                        WidgetCallFullscreenAudioShareWarningBinding widgetCallFullscreenAudioShareWarningBinding = new WidgetCallFullscreenAudioShareWarningBinding(viewFindViewById, viewFindViewById);
                        Barrier barrier = (Barrier) view.findViewById(R.id.call_audio_share_warning_barrier);
                        if (barrier != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.call_controls_sheet_container);
                            if (coordinatorLayout != null) {
                                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.call_floating_push_to_talk);
                                if (materialButton != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.call_fullscreen_mentions);
                                    if (textView != null) {
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.call_non_video_container);
                                        if (constraintLayout2 != null) {
                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.call_participants_hidden);
                                            if (linearLayout != null) {
                                                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.call_participants_show_button);
                                                if (materialButton2 != null) {
                                                    VideoCallParticipantView videoCallParticipantView = (VideoCallParticipantView) view.findViewById(R.id.call_pip);
                                                    if (videoCallParticipantView != null) {
                                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.call_stage_recycler);
                                                        if (recyclerView != null) {
                                                            MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.call_stop_streaming_button);
                                                            if (materialButton3 != null) {
                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.call_streaming_active);
                                                                if (constraintLayout3 != null) {
                                                                    TextView textView2 = (TextView) view.findViewById(R.id.call_streaming_active_body);
                                                                    if (textView2 != null) {
                                                                        TextView textView3 = (TextView) view.findViewById(R.id.call_streaming_active_header);
                                                                        if (textView3 != null) {
                                                                            ImageView imageView = (ImageView) view.findViewById(R.id.call_streaming_active_illustration);
                                                                            if (imageView != null) {
                                                                                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.call_video_recycler);
                                                                                if (recyclerView2 != null) {
                                                                                    StageCallVisitCommunityView stageCallVisitCommunityView = (StageCallVisitCommunityView) view.findViewById(R.id.call_visit_community);
                                                                                    if (stageCallVisitCommunityView != null) {
                                                                                        ViewStub viewStub = (ViewStub) view.findViewById(R.id.event_prompt_overlay_stub);
                                                                                        if (viewStub != null) {
                                                                                            View viewFindViewById2 = view.findViewById(R.id.private_call);
                                                                                            if (viewFindViewById2 != null) {
                                                                                                int i2 = R.id.private_call_blurred_grid_view;
                                                                                                PrivateCallBlurredGridView privateCallBlurredGridView = (PrivateCallBlurredGridView) viewFindViewById2.findViewById(R.id.private_call_blurred_grid_view);
                                                                                                if (privateCallBlurredGridView != null) {
                                                                                                    i2 = R.id.private_call_connectivity_status_bar;
                                                                                                    TextView textView4 = (TextView) viewFindViewById2.findViewById(R.id.private_call_connectivity_status_bar);
                                                                                                    if (textView4 != null) {
                                                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) viewFindViewById2;
                                                                                                        i2 = R.id.private_call_container_content;
                                                                                                        LinearLayout linearLayout2 = (LinearLayout) viewFindViewById2.findViewById(R.id.private_call_container_content);
                                                                                                        if (linearLayout2 != null) {
                                                                                                            i2 = R.id.private_call_grid_view;
                                                                                                            PrivateCallGridView privateCallGridView = (PrivateCallGridView) viewFindViewById2.findViewById(R.id.private_call_grid_view);
                                                                                                            if (privateCallGridView != null) {
                                                                                                                i2 = R.id.private_call_status_duration;
                                                                                                                TextView textView5 = (TextView) viewFindViewById2.findViewById(R.id.private_call_status_duration);
                                                                                                                if (textView5 != null) {
                                                                                                                    i2 = R.id.private_call_status_primary;
                                                                                                                    TextView textView6 = (TextView) viewFindViewById2.findViewById(R.id.private_call_status_primary);
                                                                                                                    if (textView6 != null) {
                                                                                                                        i2 = R.id.private_call_status_secondary;
                                                                                                                        TextView textView7 = (TextView) viewFindViewById2.findViewById(R.id.private_call_status_secondary);
                                                                                                                        if (textView7 != null) {
                                                                                                                            WidgetCallFullscreenPrivateCallBinding widgetCallFullscreenPrivateCallBinding = new WidgetCallFullscreenPrivateCallBinding(relativeLayout2, privateCallBlurredGridView, textView4, relativeLayout2, linearLayout2, privateCallGridView, textView5, textView6, textView7);
                                                                                                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.stage_call_speaking_chip);
                                                                                                                            if (constraintLayout4 != null) {
                                                                                                                                UserSummaryView userSummaryView = (UserSummaryView) view.findViewById(R.id.stage_call_speaking_user_summary);
                                                                                                                                if (userSummaryView != null) {
                                                                                                                                    MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R.id.stage_call_speaking_user_summary_label);
                                                                                                                                    if (materialTextView != null) {
                                                                                                                                        CallEventsButtonView callEventsButtonView = (CallEventsButtonView) view.findViewById(R.id.toolbar_events_button);
                                                                                                                                        if (callEventsButtonView != null) {
                                                                                                                                            VoiceCallActiveEventView voiceCallActiveEventView = (VoiceCallActiveEventView) view.findViewById(R.id.toolbar_voice_active_event);
                                                                                                                                            if (voiceCallActiveEventView != null) {
                                                                                                                                                Barrier barrier2 = (Barrier) view.findViewById(R.id.top_of_ui);
                                                                                                                                                if (barrier2 != null) {
                                                                                                                                                    VoiceControlsSheetView voiceControlsSheetView = (VoiceControlsSheetView) view.findViewById(R.id.voice_controls_sheet_view);
                                                                                                                                                    if (voiceControlsSheetView != null) {
                                                                                                                                                        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.widget_global_status);
                                                                                                                                                        if (fragmentContainerView != null) {
                                                                                                                                                            return new WidgetCallFullscreenBinding(constraintLayout, toolbar, appBarLayout, relativeLayout, widgetCallFullscreenAudioShareWarningBinding, barrier, constraintLayout, coordinatorLayout, materialButton, textView, constraintLayout2, linearLayout, materialButton2, videoCallParticipantView, recyclerView, materialButton3, constraintLayout3, textView2, textView3, imageView, recyclerView2, stageCallVisitCommunityView, viewStub, widgetCallFullscreenPrivateCallBinding, constraintLayout4, userSummaryView, materialTextView, callEventsButtonView, voiceCallActiveEventView, barrier2, voiceControlsSheetView, fragmentContainerView);
                                                                                                                                                        }
                                                                                                                                                        i = R.id.widget_global_status;
                                                                                                                                                    } else {
                                                                                                                                                        i = R.id.voice_controls_sheet_view;
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    i = R.id.top_of_ui;
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                i = R.id.toolbar_voice_active_event;
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            i = R.id.toolbar_events_button;
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        i = R.id.stage_call_speaking_user_summary_label;
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    i = R.id.stage_call_speaking_user_summary;
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                i = R.id.stage_call_speaking_chip;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById2.getResources().getResourceName(i2)));
                                                                                            }
                                                                                            i = R.id.private_call;
                                                                                        } else {
                                                                                            i = R.id.event_prompt_overlay_stub;
                                                                                        }
                                                                                    } else {
                                                                                        i = R.id.call_visit_community;
                                                                                    }
                                                                                } else {
                                                                                    i = R.id.call_video_recycler;
                                                                                }
                                                                            } else {
                                                                                i = R.id.call_streaming_active_illustration;
                                                                            }
                                                                        } else {
                                                                            i = R.id.call_streaming_active_header;
                                                                        }
                                                                    } else {
                                                                        i = R.id.call_streaming_active_body;
                                                                    }
                                                                } else {
                                                                    i = R.id.call_streaming_active;
                                                                }
                                                            } else {
                                                                i = R.id.call_stop_streaming_button;
                                                            }
                                                        } else {
                                                            i = R.id.call_stage_recycler;
                                                        }
                                                    } else {
                                                        i = R.id.call_pip;
                                                    }
                                                } else {
                                                    i = R.id.call_participants_show_button;
                                                }
                                            } else {
                                                i = R.id.call_participants_hidden;
                                            }
                                        } else {
                                            i = R.id.call_non_video_container;
                                        }
                                    } else {
                                        i = R.id.call_fullscreen_mentions;
                                    }
                                } else {
                                    i = R.id.call_floating_push_to_talk;
                                }
                            } else {
                                i = R.id.call_controls_sheet_container;
                            }
                        } else {
                            i = R.id.call_audio_share_warning_barrier;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
