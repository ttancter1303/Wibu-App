package com.example.comicapp.Repository;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.example.comicapp.data.Chapter;
import com.example.comicapp.data.Novel;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;

public class NovelRepository {
    FirebaseFirestore mFirestore;
    FirebaseStorage storage;
    StorageReference mStorageReference;

    public NovelRepository(){
        storage = FirebaseStorage.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
    }

//    public LiveData<List<Novel>> getAllNovel(){
//        MutableLiveData<List<Novel>> novels = new MutableLiveData<>(new ArrayList<>());
//       mFirestore.collection( "author")
//               .addSnapshotListener(new EventListener<QuerySnapshot>() {
//                   @Override
//                   public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                       List<Novel> novelList = new ArrayList<>();
//                       for (DocumentSnapshot document : value.getDocuments()) {
////                           Novel novel = new Novel(document.getId(),document.get("name",String.class),document.get("image",String.class),document.get("status",Boolean.class));
////                           Log.d("ttan", "onEvent: "+ novel.toString());
//                            document.getReference().collection("novel")
//                                    .addSnapshotListener(new EventListener<QuerySnapshot>() {
//                                        @Override
//                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                                            for (DocumentSnapshot valueDocument : value.getDocuments()) {
//                                                String id = valueDocument.getId();
//                                                String gioiThieu = valueDocument.get("gioi_thieu", String.class);
//                                                String image = valueDocument.get("image", String.class);
//                                                String name = valueDocument.get("name", String.class);
//                                                Boolean status = valueDocument.get("status", Boolean.class);
//                                                Novel novel = new Novel(id, name, image, status);
//
//                                                valueDocument.getReference().collection("chapter").addSnapshotListener(new EventListener<QuerySnapshot>() {
//                                                    @Override
//                                                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                                                        List<Chapter> chapters = new ArrayList<>();
//                                                        for (DocumentSnapshot document : value.getDocuments()) {
//                                                            int id = /*document.getId()*/0; // xem lai id
//                                                            String name = document.get("name", String.class);
//                                                            String content = document.get("content", String.class);
//                                                            int date = 0; // ???
//                                                            Chapter chapter = new Chapter(id, name, content);
//                                                            chapters.add(chapter);
//                                                        }
//                                                        novel.setChapters(chapters);
//                                                        novelList.add(novel);
//                                                        Log.d("ttan", "onEvent: " + novel);
//                                                    }
//                                                });
//
//                                            }
//
//                                        }
//                                    });
//                       }
//                   }
//               });
//        return novels;
//    }
    //cái hay sử dụng là allnovelv2
    public MutableLiveData<List<Novel>> getAllNovelv2(){
        MutableLiveData<List<Novel>> novels = new MutableLiveData<>(new ArrayList<>());
        mFirestore.collection( "novel")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        List<Novel> novelList = new ArrayList<>();
                        for (DocumentSnapshot document : value.getDocuments()) {
//                           Novel novel = new Novel(document.getId(),document.get("name",String.class),document.get("image",String.class),document.get("status",Boolean.class));
//                           Log.d("ttan", "onEvent: "+ novel.toString());
                            String id = document.getId();
                            String gioiThieu = document.get("intro", String.class);
                            DocumentReference image = document.get("image", DocumentReference.class);
                            String name = document.get("name", String.class);
                            Boolean status = document.get("status", Boolean.class);
                            DocumentReference author = document.get("author",DocumentReference.class);
                            Novel novel = new Novel(id, name,gioiThieu, image, author, status);
                            document.getReference().collection("chapter")
                                    .addSnapshotListener(new EventListener<QuerySnapshot>() {
                                        @Override
                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                            List<Chapter> chapters = null;
                                            for (DocumentSnapshot valueDocument : value.getDocuments()) {
                                                chapters = new ArrayList<>();
                                                String id = valueDocument.getId(); // xem lai id
                                                String name = valueDocument.get("name", String.class);
                                                String content = valueDocument.get("content", String.class);
                                                Chapter chapter = new Chapter(id, name, content);
                                                chapters.add(chapter);
                                            }
                                            novel.setChapters(chapters);
                                            novelList.add(novel);

                                        }
                                                });

                                            }

                                        }
                                    });
                        return novels;
                        }
    public MutableLiveData<List<Novel>> getAllNovelComplete(){
        MutableLiveData<List<Novel>> novels = new MutableLiveData<>(new ArrayList<>());
        mFirestore.collection( "novel")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        List<Novel> novelList = new ArrayList<>();
                        for (DocumentSnapshot document : value.getDocuments()) {
//                           Novel novel = new Novel(document.getId(),document.get("name",String.class),document.get("image",String.class),document.get("status",Boolean.class));
//                           Log.d("ttan", "onEvent: "+ novel.toString());
                            String id = document.getId();
                            String gioiThieu = document.get("intro", String.class);
                            DocumentReference image = document.get("image", DocumentReference.class);
                            String name = document.get("name", String.class);
                            Boolean status = document.get("status", Boolean.class);
                            DocumentReference author = document.get("author",DocumentReference.class);
                            Novel novel = new Novel(id, name,gioiThieu, image, author, status);
                            document.getReference().collection("chapter")
                                    .addSnapshotListener(new EventListener<QuerySnapshot>() {
                                        @Override
                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                            List<Chapter> chapters = null;
                                            for (DocumentSnapshot valueDocument : value.getDocuments()) {
                                                chapters = new ArrayList<>();
                                                String id = valueDocument.getId(); // xem lai id
                                                String name = valueDocument.get("name", String.class);
                                                String content = valueDocument.get("content", String.class);
                                                Chapter chapter = new Chapter(id, name, content);
                                                chapters.add(chapter);
                                            }
                                            if(novel.getStatus() != false){
                                                novel.setChapters(chapters);
                                                novelList.add(novel);
                                            }
                                        }
                                    });

                        }

                    }
                });
        return novels;
    }
    public MutableLiveData<List<Novel>> getAllNovel(){
        MutableLiveData<List<Novel>> novels = new MutableLiveData<>(new ArrayList<>());
        mFirestore.collection( "novel")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        List<Novel> novelList = new ArrayList<>();
                        for (DocumentSnapshot document : value.getDocuments()) {
//                           Novel novel = new Novel(document.getId(),document.get("name",String.class),document.get("image",String.class),document.get("status",Boolean.class));
//                           Log.d("ttan", "onEvent: "+ novel.toString());
                            String id = document.getId();
                            String gioiThieu = document.get("intro", String.class);
                            DocumentReference image = document.get("image", DocumentReference.class);
                            String name = document.get("name", String.class);
                            Boolean status = document.get("status", Boolean.class);
                            DocumentReference author = document.get("author",DocumentReference.class);
                            Novel novel = new Novel(id, name,gioiThieu, image, author, status);
                            document.getReference().collection("chapter")
                                    .addSnapshotListener(new EventListener<QuerySnapshot>() {
                                        @Override
                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                            List<Chapter> chapters = null;
                                            for (DocumentSnapshot valueDocument : value.getDocuments()) {
                                                chapters = new ArrayList<>();
                                                String id = valueDocument.getId(); // xem lai id
                                                String name = valueDocument.get("name", String.class);
                                                String content = valueDocument.get("content", String.class);
                                                Chapter chapter = new Chapter(id, name, content);
                                                chapters.add(chapter);
                                            }
                                            if(novel.getStatus() != false){
                                                novel.setChapters(chapters);
                                                novelList.add(novel);
                                            }
                                        }
                                    });

                        }

                    }
                });
        return novels;
    }
}
