package com.white_wolf.threeeyedcrows.service;

import com.white_wolf.threeeyedcrows.model.*;
import com.white_wolf.threeeyedcrows.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    private FriendshipService friendshipService;

    private InvitationService invitationService;

    public UserService(UserRepository userRepository, FriendshipService friendshipService, InvitationService invitationService) {
        this.userRepository = userRepository;
        this.friendshipService = friendshipService;
        this.invitationService = invitationService;
    }

    @Override
    public LoginStatus login(String username, String password) {
        Optional<User> userOptional = this.userRepository.getUserByUsername(username);
        if (userOptional.isEmpty())
            return LoginStatus.WRONG_USER;
        User user = userOptional.get();
        if (!password.equals(user.getPassword()))
            return LoginStatus.WRONG_PASSWORD;
        else
            return LoginStatus.OK;

    }

    @Override
    public boolean register(User user) {
        Optional<User> userOptional = this.userRepository.getUserByUsername(user.getUsername());
        if (userOptional.isPresent())
            return false;
        this.userRepository.save(user);
        return true;
    }

    @Override
    public List<UserGymderData> getUserGymderData(Long id) {
        List<User> allUsers = this.userRepository.findAll();
        User currentUser = this.userRepository.getOne(id);
        allUsers.remove(currentUser);
        List<User> withoutFriends = filterGymderFriends(allUsers, id);
        List<User> withoutInvites = filterGymderAlreadyInvited(withoutFriends, id);

        return convertUsersToGymderData(withoutInvites);
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public Optional<User> getUserByUserName(String username) {
        return userRepository.getUserByUsername(username);
    }

    private List<User> filterGymderFriends(List<User> users, Long id) {
        List<Friendship> friends = this.friendshipService.getUsersFriends(id);
        Iterator<User> itUsers = users.iterator();
        while (itUsers.hasNext()) {
            Iterator<Friendship> itFriends = friends.iterator();
            User currentIteratorUser = itUsers.next();
            while (itFriends.hasNext()) {
                Friendship friend = itFriends.next();
                if (currentIteratorUser.getId().equals(friend.getRoot().getId())) {
                    itUsers.remove();
                    users.remove(currentIteratorUser);
                }
            }
        }
        return users;
    }


    private List<User> filterGymderAlreadyInvited(List<User> users, Long id) {
        List<Invitation> invites = this.invitationService.getInvitations(id);
        Iterator<User> itUsers = users.iterator();
        while (itUsers.hasNext()) {
            Iterator<Invitation> itInvites = invites.iterator();
            User currentIteratorUser = itUsers.next();
            while (itInvites.hasNext()) {
                Invitation invite = itInvites.next();
                if (currentIteratorUser.getId().equals(invite.getSender().getId())) {
                    itUsers.remove();
                    users.remove(currentIteratorUser);
                }
            }
        }
        return users;
    }

    private List<UserGymderData> convertUsersToGymderData(List<User> users) {
        List<UserGymderData> gymderUsers = new ArrayList<>();
        for (User user : users) {
            UserGymderData userGymderData = new UserGymderData(user.getId(), user.getName(), user.getDescription(),
                    user.getPictureLink());
            gymderUsers.add(userGymderData);
        }
        return gymderUsers;
    }


}
