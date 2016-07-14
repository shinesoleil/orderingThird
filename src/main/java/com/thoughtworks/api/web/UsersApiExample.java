package com.thoughtworks.api.web;

//@Path("users")
//public class UsersApiExample {
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response createUser(CreateUserRequestBean info,
//                               @Context UserRepositoryExample userRepository,
//                               @Context Routes routes,
//                               @Context EncryptionService encryptionService) {
//        if (userRepository.ofId(new UserId(info.getId())).isPresent()) {
//            throw new WebApplicationException(Response.Status.BAD_REQUEST);
//        }
//        UserExample userExample = new UserExample(
//                new UserId(info.getId()),
//                info.getName(),
//                info.getEmail(),
//                info.getRole() == null ? UserRole.DEV : info.getRole(),
//                encryptionService.encrypt(info.getPassword()));
//        userRepository.save(userExample);
//        return Response.created(routes.userUrl(userExample)).build();
//    }
//
//    @Path("{userId}")
//    public UserApiExample getUser(@PathParam("userId") String userId,
//                                  @Context UserRepositoryExample userRepository) {
//        return userRepository.ofId(new UserId(userId))
//                .map(UserApiExample::new)
//                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
//    }
//}
