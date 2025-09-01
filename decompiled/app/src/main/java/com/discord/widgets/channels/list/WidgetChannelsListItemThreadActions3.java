package com.discord.widgets.channels.list;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetChannelsListItemThreadActionsBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelsListItemThreadActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetChannelsListItemThreadActionsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelsListItemThreadActionsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelsListItemThreadActions3 extends FunctionReferenceImpl implements Function1<View, WidgetChannelsListItemThreadActionsBinding> {
    public static final WidgetChannelsListItemThreadActions3 INSTANCE = new WidgetChannelsListItemThreadActions3();

    public WidgetChannelsListItemThreadActions3() {
        super(1, WidgetChannelsListItemThreadActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelsListItemThreadActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelsListItemThreadActionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelsListItemThreadActionsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.channels_list_item_thread_actions_archive_settings;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.channels_list_item_thread_actions_archive_settings);
        if (linearLayout != null) {
            i = R.id.channels_list_item_thread_actions_archive_settings_header;
            TextView textView = (TextView) view.findViewById(R.id.channels_list_item_thread_actions_archive_settings_header);
            if (textView != null) {
                i = R.id.channels_list_item_thread_actions_archive_settings_subheader;
                TextView textView2 = (TextView) view.findViewById(R.id.channels_list_item_thread_actions_archive_settings_subheader);
                if (textView2 != null) {
                    i = R.id.channels_list_item_thread_actions_channel_notifications;
                    TextView textView3 = (TextView) view.findViewById(R.id.channels_list_item_thread_actions_channel_notifications);
                    if (textView3 != null) {
                        i = R.id.channels_list_item_thread_actions_copy_id;
                        TextView textView4 = (TextView) view.findViewById(R.id.channels_list_item_thread_actions_copy_id);
                        if (textView4 != null) {
                            i = R.id.channels_list_item_thread_actions_developer_divider;
                            View viewFindViewById = view.findViewById(R.id.channels_list_item_thread_actions_developer_divider);
                            if (viewFindViewById != null) {
                                i = R.id.channels_list_item_thread_actions_divider;
                                View viewFindViewById2 = view.findViewById(R.id.channels_list_item_thread_actions_divider);
                                if (viewFindViewById2 != null) {
                                    i = R.id.channels_list_item_thread_actions_edit;
                                    TextView textView5 = (TextView) view.findViewById(R.id.channels_list_item_thread_actions_edit);
                                    if (textView5 != null) {
                                        i = R.id.channels_list_item_thread_actions_icon;
                                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.channels_list_item_thread_actions_icon);
                                        if (simpleDraweeView != null) {
                                            i = R.id.channels_list_item_thread_actions_leave;
                                            TextView textView6 = (TextView) view.findViewById(R.id.channels_list_item_thread_actions_leave);
                                            if (textView6 != null) {
                                                i = R.id.channels_list_item_thread_actions_mark_as_read;
                                                TextView textView7 = (TextView) view.findViewById(R.id.channels_list_item_thread_actions_mark_as_read);
                                                if (textView7 != null) {
                                                    i = R.id.channels_list_item_thread_actions_mute;
                                                    TextView textView8 = (TextView) view.findViewById(R.id.channels_list_item_thread_actions_mute);
                                                    if (textView8 != null) {
                                                        i = R.id.channels_list_item_thread_actions_title;
                                                        TextView textView9 = (TextView) view.findViewById(R.id.channels_list_item_thread_actions_title);
                                                        if (textView9 != null) {
                                                            i = R.id.channels_list_item_thread_actions_unarchive;
                                                            TextView textView10 = (TextView) view.findViewById(R.id.channels_list_item_thread_actions_unarchive);
                                                            if (textView10 != null) {
                                                                return new WidgetChannelsListItemThreadActionsBinding((NestedScrollView) view, linearLayout, textView, textView2, textView3, textView4, viewFindViewById, viewFindViewById2, textView5, simpleDraweeView, textView6, textView7, textView8, textView9, textView10);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
