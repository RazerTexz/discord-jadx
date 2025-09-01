package com.discord.widgets.forums;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.ForumBrowserEmptyBinding;
import b.a.i.ForumBrowserLoadingBinding;
import com.discord.R;
import com.discord.databinding.WidgetForumBrowserBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetForumBrowser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetForumBrowserBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetForumBrowserBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.forums.WidgetForumBrowser$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetForumBrowser8 extends FunctionReferenceImpl implements Function1<View, WidgetForumBrowserBinding> {
    public static final WidgetForumBrowser8 INSTANCE = new WidgetForumBrowser8();

    public WidgetForumBrowser8() {
        super(1, WidgetForumBrowserBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetForumBrowserBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetForumBrowserBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetForumBrowserBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.action_buttons_guideline;
        Guideline guideline = (Guideline) view.findViewById(R.id.action_buttons_guideline);
        if (guideline != null) {
            i = R.id.create_post;
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view.findViewById(R.id.create_post);
            if (extendedFloatingActionButton != null) {
                i = R.id.empty_view;
                View viewFindViewById = view.findViewById(R.id.empty_view);
                if (viewFindViewById != null) {
                    int i2 = R.id.forum_browser_empty_heading;
                    TextView textView = (TextView) viewFindViewById.findViewById(R.id.forum_browser_empty_heading);
                    if (textView != null) {
                        i2 = R.id.forum_browser_empty_subheading;
                        TextView textView2 = (TextView) viewFindViewById.findViewById(R.id.forum_browser_empty_subheading);
                        if (textView2 != null) {
                            i2 = R.id.forum_icon;
                            ImageView imageView = (ImageView) viewFindViewById.findViewById(R.id.forum_icon);
                            if (imageView != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
                                ForumBrowserEmptyBinding forumBrowserEmptyBinding = new ForumBrowserEmptyBinding(constraintLayout, textView, textView2, imageView, constraintLayout);
                                View viewFindViewById2 = view.findViewById(R.id.loading_view);
                                if (viewFindViewById2 != null) {
                                    ForumBrowserLoadingBinding forumBrowserLoadingBinding = new ForumBrowserLoadingBinding((ConstraintLayout) viewFindViewById2);
                                    ViewStub viewStub = (ViewStub) view.findViewById(R.id.nsfw_view);
                                    if (viewStub != null) {
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                                        if (recyclerView != null) {
                                            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.thread_browser_toolbar);
                                            if (appBarLayout != null) {
                                                Barrier barrier = (Barrier) view.findViewById(R.id.top_of_ui);
                                                if (barrier != null) {
                                                    FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.view_guidelines);
                                                    if (floatingActionButton != null) {
                                                        return new WidgetForumBrowserBinding((ConstraintLayout) view, guideline, extendedFloatingActionButton, forumBrowserEmptyBinding, forumBrowserLoadingBinding, viewStub, recyclerView, appBarLayout, barrier, floatingActionButton);
                                                    }
                                                    i = R.id.view_guidelines;
                                                } else {
                                                    i = R.id.top_of_ui;
                                                }
                                            } else {
                                                i = R.id.thread_browser_toolbar;
                                            }
                                        } else {
                                            i = R.id.recycler_view;
                                        }
                                    } else {
                                        i = R.id.nsfw_view;
                                    }
                                } else {
                                    i = R.id.loading_view;
                                }
                            }
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
