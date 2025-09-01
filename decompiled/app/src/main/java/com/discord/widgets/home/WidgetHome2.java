package com.discord.widgets.home;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import b.a.i.WidgetHomePanelCenterBinding;
import b.a.i.WidgetHomePanelCenterChatBinding;
import b.a.i.WidgetHomePanelCenterContentUnreadBinding;
import b.a.i.WidgetHomePanelLeftBinding;
import b.a.i.WidgetHomePanelLoadingBinding;
import b.a.i.WidgetHomePanelRightBinding;
import com.discord.R;
import com.discord.databinding.WidgetHomeBinding;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetHome.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetHomeBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetHomeBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.home.WidgetHome$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetHome2 extends FunctionReferenceImpl implements Function1<View, WidgetHomeBinding> {
    public static final WidgetHome2 INSTANCE = new WidgetHome2();

    public WidgetHome2() {
        super(1, WidgetHomeBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHomeBinding;", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHomeBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.loading;
        View viewFindViewById = view.findViewById(R.id.loading);
        if (viewFindViewById != null) {
            ImageView imageView = (ImageView) viewFindViewById.findViewById(R.id.logo);
            if (imageView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(R.id.logo)));
            }
            WidgetHomePanelLoadingBinding widgetHomePanelLoadingBinding = new WidgetHomePanelLoadingBinding((FrameLayout) viewFindViewById, imageView);
            i = R.id.overlapping_panels;
            HomePanelsLayout homePanelsLayout = (HomePanelsLayout) view.findViewById(R.id.overlapping_panels);
            if (homePanelsLayout != null) {
                i = R.id.panel_center;
                View viewFindViewById2 = view.findViewById(R.id.panel_center);
                if (viewFindViewById2 != null) {
                    int i2 = R.id.widget_forum_channel_list;
                    FragmentContainerView fragmentContainerView = (FragmentContainerView) viewFindViewById2.findViewById(R.id.widget_forum_channel_list);
                    if (fragmentContainerView != null) {
                        i2 = R.id.widget_home_panel_center_chat;
                        View viewFindViewById3 = viewFindViewById2.findViewById(R.id.widget_home_panel_center_chat);
                        if (viewFindViewById3 != null) {
                            int i3 = R.id.action_bar_toolbar_layout;
                            AppBarLayout appBarLayout = (AppBarLayout) viewFindViewById3.findViewById(R.id.action_bar_toolbar_layout);
                            if (appBarLayout != null) {
                                i3 = R.id.home_panel_center_channel_less;
                                ViewStub viewStub = (ViewStub) viewFindViewById3.findViewById(R.id.home_panel_center_channel_less);
                                if (viewStub != null) {
                                    i3 = R.id.home_panel_center_nsfw;
                                    ViewStub viewStub2 = (ViewStub) viewFindViewById3.findViewById(R.id.home_panel_center_nsfw);
                                    if (viewStub2 != null) {
                                        i3 = R.id.unread;
                                        View viewFindViewById4 = viewFindViewById3.findViewById(R.id.unread);
                                        if (viewFindViewById4 != null) {
                                            TextView textView = (TextView) viewFindViewById4;
                                            WidgetHomePanelCenterContentUnreadBinding widgetHomePanelCenterContentUnreadBinding = new WidgetHomePanelCenterContentUnreadBinding(textView, textView);
                                            View viewFindViewById5 = viewFindViewById3.findViewById(R.id.widget_chat_bottom_space);
                                            if (viewFindViewById5 != null) {
                                                FragmentContainerView fragmentContainerView2 = (FragmentContainerView) viewFindViewById3.findViewById(R.id.widget_chat_input);
                                                if (fragmentContainerView2 != null) {
                                                    FragmentContainerView fragmentContainerView3 = (FragmentContainerView) viewFindViewById3.findViewById(R.id.widget_chat_list);
                                                    if (fragmentContainerView3 != null) {
                                                        FragmentContainerView fragmentContainerView4 = (FragmentContainerView) viewFindViewById3.findViewById(R.id.widget_chat_overlay_actions);
                                                        if (fragmentContainerView4 != null) {
                                                            FragmentContainerView fragmentContainerView5 = (FragmentContainerView) viewFindViewById3.findViewById(R.id.widget_chat_voice_inline);
                                                            if (fragmentContainerView5 != null) {
                                                                FragmentContainerView fragmentContainerView6 = (FragmentContainerView) viewFindViewById3.findViewById(R.id.widget_forum_post_status);
                                                                if (fragmentContainerView6 != null) {
                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById3;
                                                                    FragmentContainerView fragmentContainerView7 = (FragmentContainerView) viewFindViewById3.findViewById(R.id.widget_status);
                                                                    if (fragmentContainerView7 != null) {
                                                                        FragmentContainerView fragmentContainerView8 = (FragmentContainerView) viewFindViewById3.findViewById(R.id.widget_thread_status);
                                                                        if (fragmentContainerView8 != null) {
                                                                            WidgetHomePanelCenterChatBinding widgetHomePanelCenterChatBinding = new WidgetHomePanelCenterChatBinding(constraintLayout, appBarLayout, viewStub, viewStub2, widgetHomePanelCenterContentUnreadBinding, viewFindViewById5, fragmentContainerView2, fragmentContainerView3, fragmentContainerView4, fragmentContainerView5, fragmentContainerView6, constraintLayout, fragmentContainerView7, fragmentContainerView8);
                                                                            FragmentContainerView fragmentContainerView9 = (FragmentContainerView) viewFindViewById2.findViewById(R.id.widget_home_panel_directory);
                                                                            if (fragmentContainerView9 != null) {
                                                                                WidgetHomePanelCenterBinding widgetHomePanelCenterBinding = new WidgetHomePanelCenterBinding((RoundedRelativeLayout) viewFindViewById2, fragmentContainerView, widgetHomePanelCenterChatBinding, fragmentContainerView9);
                                                                                i = R.id.panel_left;
                                                                                View viewFindViewById6 = view.findViewById(R.id.panel_left);
                                                                                if (viewFindViewById6 != null) {
                                                                                    int i4 = R.id.guild_list_add_hint;
                                                                                    TextView textView2 = (TextView) viewFindViewById6.findViewById(R.id.guild_list_add_hint);
                                                                                    if (textView2 != null) {
                                                                                        i4 = R.id.widget_channels;
                                                                                        FragmentContainerView fragmentContainerView10 = (FragmentContainerView) viewFindViewById6.findViewById(R.id.widget_channels);
                                                                                        if (fragmentContainerView10 != null) {
                                                                                            i4 = R.id.widget_guilds;
                                                                                            FragmentContainerView fragmentContainerView11 = (FragmentContainerView) viewFindViewById6.findViewById(R.id.widget_guilds);
                                                                                            if (fragmentContainerView11 != null) {
                                                                                                i4 = R.id.widget_profile_strip;
                                                                                                FrameLayout frameLayout = (FrameLayout) viewFindViewById6.findViewById(R.id.widget_profile_strip);
                                                                                                if (frameLayout != null) {
                                                                                                    WidgetHomePanelLeftBinding widgetHomePanelLeftBinding = new WidgetHomePanelLeftBinding((RelativeLayout) viewFindViewById6, textView2, fragmentContainerView10, fragmentContainerView11, frameLayout);
                                                                                                    View viewFindViewById7 = view.findViewById(R.id.panel_right);
                                                                                                    if (viewFindViewById7 != null) {
                                                                                                        int i5 = R.id.main_panel_right_rounded_container;
                                                                                                        RoundedRelativeLayout roundedRelativeLayout = (RoundedRelativeLayout) viewFindViewById7.findViewById(R.id.main_panel_right_rounded_container);
                                                                                                        if (roundedRelativeLayout != null) {
                                                                                                            i5 = R.id.widget_channel_action_bar;
                                                                                                            FragmentContainerView fragmentContainerView12 = (FragmentContainerView) viewFindViewById7.findViewById(R.id.widget_channel_action_bar);
                                                                                                            if (fragmentContainerView12 != null) {
                                                                                                                i5 = R.id.widget_channel_topic;
                                                                                                                FragmentContainerView fragmentContainerView13 = (FragmentContainerView) viewFindViewById7.findViewById(R.id.widget_channel_topic);
                                                                                                                if (fragmentContainerView13 != null) {
                                                                                                                    i5 = R.id.widget_connected_list;
                                                                                                                    FragmentContainerView fragmentContainerView14 = (FragmentContainerView) viewFindViewById7.findViewById(R.id.widget_connected_list);
                                                                                                                    if (fragmentContainerView14 != null) {
                                                                                                                        WidgetHomePanelRightBinding widgetHomePanelRightBinding = new WidgetHomePanelRightBinding((FrameLayout) viewFindViewById7, roundedRelativeLayout, fragmentContainerView12, fragmentContainerView13, fragmentContainerView14);
                                                                                                                        ImageView imageView2 = (ImageView) view.findViewById(R.id.peek_transition_bitmap);
                                                                                                                        if (imageView2 != null) {
                                                                                                                            FrameLayout frameLayout2 = (FrameLayout) view;
                                                                                                                            return new WidgetHomeBinding(frameLayout2, widgetHomePanelLoadingBinding, homePanelsLayout, widgetHomePanelCenterBinding, widgetHomePanelLeftBinding, widgetHomePanelRightBinding, imageView2, frameLayout2);
                                                                                                                        }
                                                                                                                        i = R.id.peek_transition_bitmap;
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById7.getResources().getResourceName(i5)));
                                                                                                    }
                                                                                                    i = R.id.panel_right;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById6.getResources().getResourceName(i4)));
                                                                                }
                                                                            } else {
                                                                                i2 = R.id.widget_home_panel_directory;
                                                                            }
                                                                        } else {
                                                                            i3 = R.id.widget_thread_status;
                                                                        }
                                                                    } else {
                                                                        i3 = R.id.widget_status;
                                                                    }
                                                                } else {
                                                                    i3 = R.id.widget_forum_post_status;
                                                                }
                                                            } else {
                                                                i3 = R.id.widget_chat_voice_inline;
                                                            }
                                                        } else {
                                                            i3 = R.id.widget_chat_overlay_actions;
                                                        }
                                                    } else {
                                                        i3 = R.id.widget_chat_list;
                                                    }
                                                } else {
                                                    i3 = R.id.widget_chat_input;
                                                }
                                            } else {
                                                i3 = R.id.widget_chat_bottom_space;
                                            }
                                        }
                                    }
                                }
                            }
                            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById3.getResources().getResourceName(i3)));
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById2.getResources().getResourceName(i2)));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHomeBinding invoke(View view) {
        return invoke2(view);
    }
}
