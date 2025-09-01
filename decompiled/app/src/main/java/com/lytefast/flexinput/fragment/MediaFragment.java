package com.lytefast.flexinput.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b.b.a.FlexInputCoordinator;
import b.b.a.d.MediaCursorAdapter;
import com.discord.utilities.display.DisplayUtils;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.adapters.EmptyListAdapter;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Media;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: MediaFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b+\u0010\u0013J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001a\u0010\u0013R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR*\u0010\"\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0004\u0012\u00020!\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/lytefast/flexinput/fragment/MediaFragment;", "Landroidx/fragment/app/Fragment;", "", "", "requiredPermissionList", "", "hasPermissions", "([Ljava/lang/String;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onResume", "()V", "onPause", "Landroid/view/View$OnClickListener;", "onClickListener", "Lcom/lytefast/flexinput/adapters/EmptyListAdapter;", "newPermissionsRequestAdapter", "(Landroid/view/View$OnClickListener;)Lcom/lytefast/flexinput/adapters/EmptyListAdapter;", "onDestroyView", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "swipeRefreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "Lcom/lytefast/flexinput/utils/SelectionCoordinator;", "Lcom/lytefast/flexinput/model/Attachment;", "", "Lcom/lytefast/flexinput/model/Media;", "selectionCoordinator", "Lcom/lytefast/flexinput/utils/SelectionCoordinator;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView$flexinput_release", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView$flexinput_release", "(Landroidx/recyclerview/widget/RecyclerView;)V", "<init>", "Companion", "flexinput_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class MediaFragment extends Fragment {
    private static final int GRID_LAYOUT_SPAN_COUNT = 3;
    private static final String REQUIRED_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    private RecyclerView recyclerView;
    private SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator;
    private SwipeRefreshLayout swipeRefreshLayout;

    /* compiled from: MediaFragment.kt */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ View j;
        public final /* synthetic */ MediaCursorAdapter k;
        public final /* synthetic */ MediaFragment l;
        public final /* synthetic */ FlexInputCoordinator m;

        /* compiled from: MediaFragment.kt */
        /* renamed from: com.lytefast.flexinput.fragment.MediaFragment$a$a, reason: collision with other inner class name */
        public static final class C0370a extends Lambda implements Function0<Unit> {
            public C0370a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                RecyclerView recyclerView = a.this.l.getRecyclerView();
                Intrinsics3.checkNotNull(recyclerView);
                recyclerView.setLayoutManager(new GridLayoutManager(a.this.j.getContext(), 3));
                RecyclerView recyclerView2 = a.this.l.getRecyclerView();
                Intrinsics3.checkNotNull(recyclerView2);
                recyclerView2.setAdapter(a.this.k);
                RecyclerView recyclerView3 = a.this.l.getRecyclerView();
                Intrinsics3.checkNotNull(recyclerView3);
                recyclerView3.invalidateItemDecorations();
                return Unit.a;
            }
        }

        public a(View view, MediaCursorAdapter mediaCursorAdapter, MediaFragment mediaFragment, FlexInputCoordinator flexInputCoordinator) {
            this.j = view;
            this.k = mediaCursorAdapter;
            this.l = mediaFragment;
            this.m = flexInputCoordinator;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FlexInputCoordinator flexInputCoordinator = this.m;
            if (flexInputCoordinator != null) {
                flexInputCoordinator.requestMediaPermissions(new C0370a());
            }
        }
    }

    /* compiled from: MediaFragment.kt */
    public static final class b implements SwipeRefreshLayout.OnRefreshListener {
        public final /* synthetic */ View a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MediaCursorAdapter f3167b;
        public final /* synthetic */ MediaFragment c;
        public final /* synthetic */ FlexInputCoordinator d;

        public b(View view, MediaCursorAdapter mediaCursorAdapter, MediaFragment mediaFragment, FlexInputCoordinator flexInputCoordinator) {
            this.a = view;
            this.f3167b = mediaCursorAdapter;
            this.c = mediaFragment;
            this.d = flexInputCoordinator;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            if (MediaFragment.access$hasPermissions(this.c, MediaFragment.REQUIRED_PERMISSION)) {
                MediaCursorAdapter mediaCursorAdapter = this.f3167b;
                Context context = this.a.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                ContentResolver contentResolver = context.getContentResolver();
                Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                mediaCursorAdapter.b(contentResolver);
            }
            SwipeRefreshLayout swipeRefreshLayoutAccess$getSwipeRefreshLayout$p = MediaFragment.access$getSwipeRefreshLayout$p(this.c);
            if (swipeRefreshLayoutAccess$getSwipeRefreshLayout$p != null) {
                swipeRefreshLayoutAccess$getSwipeRefreshLayout$p.setRefreshing(false);
            }
        }
    }

    public static final /* synthetic */ SwipeRefreshLayout access$getSwipeRefreshLayout$p(MediaFragment mediaFragment) {
        return mediaFragment.swipeRefreshLayout;
    }

    public static final /* synthetic */ boolean access$hasPermissions(MediaFragment mediaFragment, String... strArr) {
        return mediaFragment.hasPermissions(strArr);
    }

    public static final /* synthetic */ void access$setSwipeRefreshLayout$p(MediaFragment mediaFragment, SwipeRefreshLayout swipeRefreshLayout) {
        mediaFragment.swipeRefreshLayout = swipeRefreshLayout;
    }

    private final boolean hasPermissions(String... requiredPermissionList) {
        int length = requiredPermissionList.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return true;
            }
            if (!(ContextCompat.checkSelfPermission(requireContext(), requiredPermissionList[i]) == 0)) {
                return false;
            }
            i++;
        }
    }

    /* renamed from: getRecyclerView$flexinput_release, reason: from getter */
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public EmptyListAdapter newPermissionsRequestAdapter(View.OnClickListener onClickListener) {
        Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
        return new EmptyListAdapter(R.g.item_permission_storage, R.f.permissions_req_btn, onClickListener);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(inflater, "inflater");
        this.selectionCoordinator = new SelectionCoordinator<>(null, null, 3);
        Fragment parentFragment = getParentFragment();
        ActivityResultCaller parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        if (!(parentFragment2 instanceof FlexInputCoordinator)) {
            parentFragment2 = null;
        }
        FlexInputCoordinator flexInputCoordinator = (FlexInputCoordinator) parentFragment2;
        if (flexInputCoordinator != null) {
            SelectionAggregator selectionAggregatorB = flexInputCoordinator.b();
            SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator = this.selectionCoordinator;
            Intrinsics3.checkNotNull(selectionCoordinator);
            selectionAggregatorB.registerSelectionCoordinator(selectionCoordinator);
        }
        View viewInflate = inflater.inflate(R.g.fragment_recycler_view, container, false);
        if (viewInflate == null) {
            return null;
        }
        this.recyclerView = (RecyclerView) viewInflate.findViewById(R.f.list);
        Intrinsics3.checkNotNullExpressionValue(viewInflate.getContext(), "context");
        int iWidth = (int) (DisplayUtils.getScreenSize(r6).width() / 3);
        SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator2 = this.selectionCoordinator;
        Intrinsics3.checkNotNull(selectionCoordinator2);
        MediaCursorAdapter mediaCursorAdapter = new MediaCursorAdapter(selectionCoordinator2, iWidth, iWidth);
        if (hasPermissions(REQUIRED_PERMISSION)) {
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new GridLayoutManager(viewInflate.getContext(), 3));
            }
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(mediaCursorAdapter);
            }
        } else {
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(newPermissionsRequestAdapter(new a(viewInflate, mediaCursorAdapter, this, flexInputCoordinator)));
            }
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(R.f.swipeRefreshLayout);
        this.swipeRefreshLayout = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new b(viewInflate, mediaCursorAdapter, this, flexInputCoordinator));
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SelectionCoordinator<Attachment<Object>, Media> selectionCoordinator = this.selectionCoordinator;
        Intrinsics3.checkNotNull(selectionCoordinator);
        selectionCoordinator.itemSelectionListener.unregister();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(true);
        }
    }

    public final void setRecyclerView$flexinput_release(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
