package com.discord.widgets.channels.list;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetChannelsListItemActionsBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelsListItemChannelActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetChannelsListItemActionsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelsListItemActionsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelsListItemChannelActions$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetChannelsListItemActionsBinding> {
    public static final WidgetChannelsListItemChannelActions$binding$2 INSTANCE = new WidgetChannelsListItemChannelActions$binding$2();

    public WidgetChannelsListItemChannelActions$binding$2() {
        super(1, WidgetChannelsListItemActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelsListItemActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelsListItemActionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelsListItemActionsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_channel_notifications;
        TextView textView = (TextView) view.findViewById(R.id.action_channel_notifications);
        if (textView != null) {
            i = R.id.action_channel_settings;
            TextView textView2 = (TextView) view.findViewById(R.id.action_channel_settings);
            if (textView2 != null) {
                i = R.id.action_copy_id;
                TextView textView3 = (TextView) view.findViewById(R.id.action_copy_id);
                if (textView3 != null) {
                    i = R.id.action_invite;
                    TextView textView4 = (TextView) view.findViewById(R.id.action_invite);
                    if (textView4 != null) {
                        i = R.id.channels_list_item_text_actions_icon;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.channels_list_item_text_actions_icon);
                        if (simpleDraweeView != null) {
                            i = R.id.channels_list_item_text_actions_title;
                            TextView textView5 = (TextView) view.findViewById(R.id.channels_list_item_text_actions_title);
                            if (textView5 != null) {
                                i = R.id.developer_divider;
                                View viewFindViewById = view.findViewById(R.id.developer_divider);
                                if (viewFindViewById != null) {
                                    i = R.id.dm_action_profile;
                                    TextView textView6 = (TextView) view.findViewById(R.id.dm_action_profile);
                                    if (textView6 != null) {
                                        i = R.id.text_action_mark_as_read;
                                        TextView textView7 = (TextView) view.findViewById(R.id.text_action_mark_as_read);
                                        if (textView7 != null) {
                                            i = R.id.text_action_mute;
                                            TextView textView8 = (TextView) view.findViewById(R.id.text_action_mute);
                                            if (textView8 != null) {
                                                i = R.id.text_action_thread_browser;
                                                TextView textView9 = (TextView) view.findViewById(R.id.text_action_thread_browser);
                                                if (textView9 != null) {
                                                    return new WidgetChannelsListItemActionsBinding((NestedScrollView) view, textView, textView2, textView3, textView4, simpleDraweeView, textView5, viewFindViewById, textView6, textView7, textView8, textView9);
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
