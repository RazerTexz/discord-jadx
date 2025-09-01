package com.lytefast.flexinput.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b.b.a.FlexInputCoordinator;
import b.b.a.a.FilesFragment2;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.adapters.EmptyListAdapter;
import com.lytefast.flexinput.adapters.FileListAdapter;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.File;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: FilesFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R0\u0010%\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\"\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/lytefast/flexinput/fragment/FilesFragment;", "Landroidx/fragment/app/Fragment;", "", "loadDownloadFolder", "()V", "", "", "requiredPermissionList", "", "hasPermissions", "([Ljava/lang/String;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/view/View$OnClickListener;", "onClickListener", "Lcom/lytefast/flexinput/adapters/EmptyListAdapter;", "newPermissionsRequestAdapter", "(Landroid/view/View$OnClickListener;)Lcom/lytefast/flexinput/adapters/EmptyListAdapter;", "onStart", "onDestroyView", "Lcom/lytefast/flexinput/adapters/FileListAdapter;", "adapter", "Lcom/lytefast/flexinput/adapters/FileListAdapter;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "swipeRefreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "Lcom/lytefast/flexinput/utils/SelectionCoordinator;", "Lcom/lytefast/flexinput/model/Attachment;", "", "Ljava/io/File;", "selectionCoordinator", "Lcom/lytefast/flexinput/utils/SelectionCoordinator;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView$flexinput_release", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView$flexinput_release", "(Landroidx/recyclerview/widget/RecyclerView;)V", "<init>", "Companion", "flexinput_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class FilesFragment extends Fragment {
    private static final String REQUIRED_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    private FileListAdapter adapter;
    private RecyclerView recyclerView;
    private SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator;
    private SwipeRefreshLayout swipeRefreshLayout;

    /* compiled from: FilesFragment.kt */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ View j;
        public final /* synthetic */ FilesFragment k;
        public final /* synthetic */ FlexInputCoordinator l;

        /* compiled from: FilesFragment.kt */
        /* renamed from: com.lytefast.flexinput.fragment.FilesFragment$a$a, reason: collision with other inner class name */
        public static final class C0369a extends Lambda implements Function0<Unit> {
            public C0369a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                ContentResolver contentResolver;
                Context context = a.this.j.getContext();
                if (context != null && (contentResolver = context.getContentResolver()) != null) {
                    FilesFragment filesFragment = a.this.k;
                    SelectionCoordinator selectionCoordinatorAccess$getSelectionCoordinator$p = FilesFragment.access$getSelectionCoordinator$p(filesFragment);
                    Intrinsics3.checkNotNull(selectionCoordinatorAccess$getSelectionCoordinator$p);
                    FilesFragment.access$setAdapter$p(filesFragment, new FileListAdapter(contentResolver, selectionCoordinatorAccess$getSelectionCoordinator$p));
                    RecyclerView recyclerView = a.this.k.getRecyclerView();
                    if (recyclerView != null) {
                        recyclerView.setAdapter(FilesFragment.access$getAdapter$p(a.this.k));
                    }
                    FilesFragment.access$loadDownloadFolder(a.this.k);
                }
                return Unit.a;
            }
        }

        public a(View view, FilesFragment filesFragment, FlexInputCoordinator flexInputCoordinator) {
            this.j = view;
            this.k = filesFragment;
            this.l = flexInputCoordinator;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FlexInputCoordinator flexInputCoordinator = this.l;
            if (flexInputCoordinator != null) {
                flexInputCoordinator.requestMediaPermissions(new C0369a());
            }
        }
    }

    /* compiled from: FilesFragment.kt */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function0<Unit> {
        public b(FilesFragment filesFragment) {
            super(0, filesFragment, FilesFragment.class, "loadDownloadFolder", "loadDownloadFolder()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            FilesFragment.access$loadDownloadFolder((FilesFragment) this.receiver);
            return Unit.a;
        }
    }

    public static final /* synthetic */ FileListAdapter access$getAdapter$p(FilesFragment filesFragment) {
        return filesFragment.adapter;
    }

    public static final /* synthetic */ SelectionCoordinator access$getSelectionCoordinator$p(FilesFragment filesFragment) {
        return filesFragment.selectionCoordinator;
    }

    public static final /* synthetic */ void access$loadDownloadFolder(FilesFragment filesFragment) {
        filesFragment.loadDownloadFolder();
    }

    public static final /* synthetic */ void access$setAdapter$p(FilesFragment filesFragment, FileListAdapter fileListAdapter) {
        filesFragment.adapter = fileListAdapter;
    }

    public static final /* synthetic */ void access$setSelectionCoordinator$p(FilesFragment filesFragment, SelectionCoordinator selectionCoordinator) {
        filesFragment.selectionCoordinator = selectionCoordinator;
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

    private final void loadDownloadFolder() {
        if (this.adapter == null) {
            SwipeRefreshLayout swipeRefreshLayout = this.swipeRefreshLayout;
            Intrinsics3.checkNotNull(swipeRefreshLayout);
            swipeRefreshLayout.setRefreshing(false);
            return;
        }
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        FileListAdapter fileListAdapter = this.adapter;
        Intrinsics3.checkNotNull(fileListAdapter);
        Intrinsics3.checkNotNullExpressionValue(externalStoragePublicDirectory, "downloadFolder");
        Objects.requireNonNull(fileListAdapter);
        Intrinsics3.checkNotNullParameter(externalStoragePublicDirectory, "root");
        new FileListAdapter.a(fileListAdapter).execute(externalStoragePublicDirectory);
        SwipeRefreshLayout swipeRefreshLayout2 = this.swipeRefreshLayout;
        Intrinsics3.checkNotNull(swipeRefreshLayout2);
        swipeRefreshLayout2.setRefreshing(false);
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
            SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator = this.selectionCoordinator;
            Intrinsics3.checkNotNull(selectionCoordinator);
            selectionAggregatorB.registerSelectionCoordinator(selectionCoordinator);
        }
        View viewInflate = inflater.inflate(R.g.fragment_recycler_view, container, false);
        if (viewInflate == null) {
            return null;
        }
        this.recyclerView = (RecyclerView) viewInflate.findViewById(R.f.list);
        if (hasPermissions(REQUIRED_PERMISSION)) {
            Context context = viewInflate.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator2 = this.selectionCoordinator;
            Intrinsics3.checkNotNull(selectionCoordinator2);
            FileListAdapter fileListAdapter = new FileListAdapter(contentResolver, selectionCoordinator2);
            this.adapter = fileListAdapter;
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.setAdapter(fileListAdapter);
            }
        } else {
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(newPermissionsRequestAdapter(new a(viewInflate, this, flexInputCoordinator)));
            }
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) viewInflate.findViewById(R.f.swipeRefreshLayout);
        this.swipeRefreshLayout = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new FilesFragment2(new b(this)));
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SelectionCoordinator<Attachment<Object>, Attachment<File>> selectionCoordinator = this.selectionCoordinator;
        if (selectionCoordinator != null) {
            selectionCoordinator.itemSelectionListener.unregister();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        loadDownloadFolder();
    }

    public final void setRecyclerView$flexinput_release(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
